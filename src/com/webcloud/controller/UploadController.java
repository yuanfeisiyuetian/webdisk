package com.webcloud.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.webcloud.biz.FileforusrBiz;
import com.webcloud.entity.Fileforusr;


@Controller
@RequestMapping("file")
public class UploadController {
	@Autowired
	CommonsMultipartResolver multipartResolver;
	
	@Autowired
	private FileforusrBiz fileforusrbiz;
	
	
	//文件上传
		@RequestMapping("upload")
		public String upload(@RequestParam("file") CommonsMultipartFile files[],Fileforusr fileforusr,HttpServletRequest request,HttpServletResponse response,HttpSession session)
		throws IllegalStateException,IOException{
			session.removeAttribute("msg");
		    //记录上传过程起始时的时间，用来计算上传时间
		    int pre = (int) System.currentTimeMillis();
			for(int i=0;i<files.length;i++){
			    if(!files[i].isEmpty()){
			        //取得当前上传文件的文件名称
			        String myFileName = files[i].getOriginalFilename();
			        System.out.println(myFileName);
			        //重命名上传后的文件名
			        String fileName = UUID.randomUUID().toString() + "_"  + files[i].getOriginalFilename();
			        //获取文件后缀名
			        String fileExtName = myFileName.substring(myFileName.lastIndexOf(".")+1);
			        //定义上传路径
			        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/") + fileName;
			        System.out.println(path);
			        File localFile = new File(path);
			        try {
			        	files[i].transferTo(localFile);
	                    //更改数据库
	                    int uid = (Integer)session.getAttribute("uid");
	                    fileforusr.setUid(uid);
	                    fileforusr.setUfilename(myFileName);
	                    fileforusr.setUfilenameSave(fileName);
	                    fileforusr.setUfileformat(fileExtName);
	                    fileforusr.setUploadtime(new Date());
	                    String subpath = path.substring(path.indexOf("upload")+7);
	                    fileforusr.setUpathSave(subpath);
	                    BigDecimal size = new BigDecimal(files[i].getSize());
	                    fileforusr.setUsize(size);
	                    fileforusr.setIsrecycle(false);
	                    fileforusr.setIsshare(false);
	                    fileforusrbiz.uploadFile(fileforusr);
	                    System.out.println("存到数据库的id为"+fileforusr.getUfileid());
	                 } catch (Exception e) {
	                	 e.printStackTrace();
	                	 session.setAttribute("msg", "文件上传失败，请重试");
	                     return "upload";
	                     }
			        }
			    else{
			    	session.setAttribute("msg","请选择文件");
	                return "upload";
	                }
			    }
			//记录上传该文件后的时间
			int finaltime = (int) System.currentTimeMillis();
			System.out.println(finaltime - pre);
			return "success";
		}
		
		
		//获取文件大小
		public static String getPrintSize(long size) {	
			// 如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义	
			double value = (double) size;		
			if (value < 1024) {
				return String.valueOf(value) + "B";		
			}
			else {	
				value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();	
			}		
			// 如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位		
			// 因为还没有到达要使用另一个单位的时候		
			// 接下去以此类推		
			if (value < 1024) {		
				return String.valueOf(value) + "KB";		
			} 
			else {	
				value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();	
				}		
			if (value < 1024) {	
				return String.valueOf(value) + "MB";
				} 
			else {	
					// 否则如果要以GB为单位的，先除于1024再作同样的处理	
					value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();	
					return String.valueOf(value) + "GB";		
			}	
		}
		
		
		//文件下载
		@RequestMapping("download")
		public ResponseEntity<byte[]> download(HttpServletRequest request,HttpServletResponse response) 
		throws IllegalStateException,IOException{
			try{
				Fileforusr fileforusr = fileforusrbiz.selectByUfileID(Integer.parseInt(request.getParameter("key")));
				String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/") + fileforusr.getUpathSave();
				File file = new File(path);
				System.out.println(path);
				HttpHeaders headers = new HttpHeaders();
		        String filename = this.getFilename(request, fileforusr.getUfilename());
				headers.setContentDispositionFormData("attachment", filename);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}		
		}
		
		//下载的文件名称不要乱码
		public String getFilename(HttpServletRequest request,String filename) throws Exception{
	        String[] IEBrowserKeyWord = {"MSIE","Trident","Edge"};
	        String userAgent = request.getHeader("User-Agent");
	        for(String keyWord:IEBrowserKeyWord){
	            if(userAgent.contains(keyWord)){
	                return URLEncoder.encode(filename,"UTF-8");
	            }
	        }
	        return new String(filename.getBytes("UTF-8"),"ISO-8859-1");
	    }
		
		//文件从服务器上删除
		@RequestMapping("deltotal")
		public String delete(HttpServletRequest request){
			Fileforusr fileforusr = fileforusrbiz.selectByUfileID(Integer.parseInt(request.getParameter("key")));
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/") + fileforusr.getUpathSave();
			File file = new File(path);
			if(file.exists()){
				file.delete();
				fileforusrbiz.deletefile(fileforusr);
			}
			else{
				System.out.print("出现错误");
			}
			return "redirect:/main/recycle.do";
		}
}
