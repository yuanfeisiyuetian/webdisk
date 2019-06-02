package com.webcloud.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.regexp.internal.recompile;
import com.webcloud.biz.FileforusrBiz;
import com.webcloud.biz.ShareforusrBiz;
import com.webcloud.entity.Fileforusr;
import com.webcloud.entity.Shareforusr;

@Controller
@RequestMapping(value="share")
public class FileShareController {

	@Autowired
	private ShareforusrBiz shareforusrbiz;
	
	@Autowired
	private FileforusrBiz fileforusrbiz;
	
	//显示分享列表
	@RequestMapping(value="init")
	public String init(Map map,HttpSession session){
		int uid = (Integer)session.getAttribute("uid");
		List<Shareforusr> shareforusrlist = shareforusrbiz.selectByUid(uid);
		try{	//捕捉没有文件报错异常
			for(int i=0;i<shareforusrlist.size();i++){
				Shareforusr shareforusr = shareforusrlist.get(i);
				if(new Date().after(shareforusrlist.get(i).getUsharedateend())){
					shareforusrbiz.deleteshare(shareforusr);
					shareforusrlist.remove(i);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		map.put("shareforusrlist", shareforusrlist);
		return "forward:/share.jsp";
	}
	
	
	//分享设置
	@RequestMapping(value="create")
	public String create(HttpServletRequest request,Map map,HttpSession session){
		session.removeAttribute("msg");
		try{
			System.out.println(request.getParameter("key"));
			Fileforusr fileforusr = fileforusrbiz.selectByUfileID(Integer.parseInt(request.getParameter("key")));
			Shareforusr shareforusr = shareforusrbiz.selectByUfileid(fileforusr.getUfileid());
			if(shareforusr==null){
				session.setAttribute("file", fileforusr);
				String filename = fileforusr.getUfilename();
	//			System.out.println(filename);
				session.setAttribute("filename", filename);
				return "forward:/shareset.jsp";
			}else{
				map.put("shareforusr", shareforusr);
				return "forward:/link.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("msg", "服务器出现错误，请稍后再试");
			return "redirect:/main/init.do";
		}
	}
	
	//生成分享链接
	@RequestMapping(value="link")
	public String link(HttpSession session,String time,String way,Shareforusr shareforusr){
		Calendar calendar = Calendar.getInstance();
		int uid = (Integer)session.getAttribute("uid");
		shareforusr.setUid(uid);
		Date date = new Date();
		shareforusr.setUsharedate(date);
		Fileforusr fileforusr = (Fileforusr) session.getAttribute("file");
		shareforusr.setUfileid(fileforusr.getUfileid());
		fileforusr.setIsshare(true);	//更改file分享的属性
		fileforusrbiz.updateFile(fileforusr);
		shareforusr.setUfilename(fileforusr.getUfilename());
		String password = null;
		if(way.equals("0")){
			password = this.generateWord();
		}
		shareforusr.setUfilepassword(password);
		if(time.equals("1")){
			calendar.add(calendar.DATE, 3);
			date = calendar.getTime();
			shareforusr.setUsharedateend(date);
		}else if(time.equals("2")){
			calendar.add(calendar.DATE, 7);
			date = calendar.getTime();
			shareforusr.setUsharedateend(date);
		}else{
			calendar.add(calendar.DATE, 999999999);
			date = calendar.getTime();
			shareforusr.setUsharedateend(date);
		}
		String url = fileforusr.getUpathSave().substring(0, 36);
		shareforusr.setUfilepath(url);
		shareforusrbiz.insertshare(shareforusr);
		return "forward:/link.jsp";
		
	}
	
	//生成四位随机数
	 private String generateWord() {
		 String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		 StringBuilder sb=new StringBuilder(4);
		 for(int i=0;i<4;i++){     
			 char ch=str.charAt(new Random().nextInt(str.length()));   
			 sb.append(ch);
		 }
	      return sb.toString();
	 }
	 
	 @RequestMapping(value="showlink")
	 public String showlink(Map map,HttpServletRequest request){
		 Shareforusr shareforusr = shareforusrbiz.selectByUfileid(Integer.parseInt(request.getParameter("key")));
		 map.put("shareforusr", shareforusr);
		 return "forward:/link.jsp";
	 }
	 
	 @RequestMapping(value="search")
	 public String search(Map map,String ufilepath,HttpSession session){
		 session.removeAttribute("msg");
		 Shareforusr shareforusr = shareforusrbiz.showshare(ufilepath);
		 if(shareforusr!=null){
			 if(shareforusr.getUsharedateend().before(new Date())){	//分享过期
				 shareforusrbiz.deleteshare(shareforusr);
				 session.setAttribute("msg", "文件不存在");
				 return "forward:/share/init.do";
			 }
			 if(shareforusr.getUfilepassword()==null){
				 Fileforusr fileforusr = fileforusrbiz.selectByUfileID(shareforusr.getUfileid());
				 map.put("fileforusr", fileforusr);
				 return "forward:/showshare.jsp";
			 }
			 else {
				 session.setAttribute("shareforusr", shareforusr);
				 return "forward:/sharetoken.jsp";
			 }
		 }
		 else{
			 session.setAttribute("msg", "文件不存在");
			 return "forward:/share/init.do";
		 }
	 }
	 
	 
	 @RequestMapping(value="credit")
	 public String credit(HttpSession session,Map map,String pwd){
		 session.removeAttribute("msg");
		 Shareforusr shareforusr = (Shareforusr)session.getAttribute("shareforusr");
		 if(shareforusr.getUfilepassword().equals(pwd)){
			 Fileforusr fileforusr = fileforusrbiz.selectByUfileID(shareforusr.getUfileid());
			 map.put("fileforusr", fileforusr);
			 return "forward:/showshare.jsp";
		 }
		 else {
			 session.setAttribute("msg", "密码错误");
			 return "forward:/sharetoken.jsp";
		 }
	 }
	 
	 @RequestMapping(value="del")
	 public String del(HttpServletRequest request){
		 Shareforusr shareforusr = shareforusrbiz.selectByUfileid(Integer.parseInt(request.getParameter("key")));
		 shareforusrbiz.deleteshare(shareforusr);
		 return "forward:/share/init.do";
	 }
	 
}
