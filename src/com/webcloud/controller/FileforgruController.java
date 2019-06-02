package com.webcloud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webcloud.biz.FileforgruBiz;
import com.webcloud.biz.GroupBiz;
import com.webcloud.biz.GroupjoinBiz;
import com.webcloud.biz.GroupmanageBiz;
import com.webcloud.entity.Fileforgru;
import com.webcloud.entity.Fileforusr;
import com.webcloud.entity.Group;
import com.webcloud.entity.Manage;

@Controller
@RequestMapping("groupfile")
public class FileforgruController {
		
	@Autowired
	private FileforgruBiz fileforgrubiz;
	
	@Autowired
	private GroupBiz groupbiz;
	
	@Autowired
	private GroupjoinBiz groupjoinbiz;
	
	@Autowired
	private GroupmanageBiz groupmanagebiz;
	
	//显示群组文件列表
	@RequestMapping(value="init")
	public String init(Map map,HttpSession session,HttpServletRequest request,Map auth,Map groupname){
		int gid;
		System.out.println(request.getParameter("key"));
		if(request.getParameter("key")!=null){	//从页面点击跳转
			gid = Integer.parseInt(request.getParameter("key"));
			session.setAttribute("gid", gid);
			session.setAttribute("group", groupbiz.selectByGid(gid));
		}
		else gid = (Integer)session.getAttribute("gid");	//新建或加入一个群组时的跳转
		System.out.println(gid);
		List<Fileforgru> fileforgrulist = fileforgrubiz.selectByGid(gid);
		try{	//捕捉没有文件报错异常
			System.out.println(fileforgrulist.get(0).getGfilename());
		}catch(Exception e){
			e.printStackTrace();
		}
		map.put("fileforgrulist", fileforgrulist);
		
		//找对应角色权限
		Group group = groupbiz.selectByGid(gid);
		String gname = group.getGname();
		System.out.println(gname);
		int uid = (int)session.getAttribute("uid");
		if(uid==group.getOid()){
			auth.put("auth", (short)7);	//群主权限为7
		}
		else{
			List<Manage> managelist = groupmanagebiz.showmanager(gid);
			List<Integer> userlist = new ArrayList<Integer>();
			for(int i=0;i<managelist.size();i++){
				userlist.add(managelist.get(i).getUid());
			}
			if(userlist.contains(uid)){
				auth.put("auth", group.getManagerauth());
			}
			else auth.put("auth", group.getUauth());	//不在manage组里只能在普通用户组中了
		}
		groupname.put("groupname", gname);
		return "forward:/groupindex.jsp";
	}
	
	@RequestMapping(value="del")
	public String del(HttpServletRequest request){
		Fileforgru fileforgru = fileforgrubiz.selectByGFileid(Integer.parseInt(request.getParameter("key")));
		System.out.println(fileforgru.getGfilename());
		fileforgru.setIsrecycle(true);
		fileforgru.setGlmodtime(new Date());		//懒得改数据库了这个就当作删除时间了
		fileforgrubiz.updateFile(fileforgru);
		return "redirect:/groupfile/init.do";
	}
	
	//显示回收站
	@RequestMapping(value="recycle")
	public String recycle(Map map,HttpSession session,Map groupname) {
		int gid = (Integer)session.getAttribute("gid");
		String gname = groupbiz.selectByGid(gid).getGname();
		System.out.println(gid);
		List<Fileforgru> fileforgrulist = fileforgrubiz.selectByGidr(gid);
		try{
			System.out.println(fileforgrulist.get(0).getGfilename());
		}catch(Exception e){
			e.printStackTrace();
		}
		map.put("fileforgrulist", fileforgrulist);
		groupname.put("groupname", gname);
		return "forward:/grouprecycle.jsp";
	}
	
	@RequestMapping(value="back")
	public String back(HttpServletRequest request){
		Fileforgru fileforgru = fileforgrubiz.selectByGFileid(Integer.parseInt(request.getParameter("key")));
		System.out.println(fileforgru.getGfilename());
		fileforgru.setIsrecycle(false);
		fileforgru.setGlmodtime(null);		//懒得改数据库了这个就当作删除时间了
		fileforgrubiz.updateFile(fileforgru);
		return "redirect:/groupfile/init.do";
	}
	
	//搜索文件
	@RequestMapping(value="search")
	public String search(Map map,HttpSession session,HttpServletRequest request,Map auth,Map groupname,String filename){
		int gid = (Integer)session.getAttribute("gid");
		Fileforgru fileforgru = new Fileforgru();
		fileforgru.setGid(gid);
		fileforgru.setGfilename(filename);
		List<Fileforgru> fileforgrulist = fileforgrubiz.selectByGName(fileforgru);
		for(int i=0;i<fileforgrulist.size();i++){
			if(fileforgrulist.get(i).getIsrecycle()==true){
				fileforgrulist.remove(i);
			}
		}
		try{
			System.out.println(fileforgrulist.get(0).getGfilename());
		}catch(Exception e){
			e.printStackTrace();
		}
		map.put("fileforgrulist", fileforgrulist);
		
		//找对应角色权限
		Group group = groupbiz.selectByGid(gid);
		String gname = group.getGname();
		System.out.println(gname);
		int uid = (int)session.getAttribute("uid");
		if(uid==group.getOid()){
			auth.put("auth", (short)7);	//群主权限为7
		}
		else{
			List<Manage> managelist = groupmanagebiz.showmanager(gid);
			List<Integer> userlist = new ArrayList<Integer>();
			for(int i=0;i<managelist.size();i++){
				userlist.add(managelist.get(i).getUid());
			}
			if(userlist.contains(uid)){
				auth.put("auth", group.getManagerauth());
			}
			else auth.put("auth", group.getUauth());	//不在manage组里只能在普通用户组中了
		}
		groupname.put("groupname", gname);
				
		return "forward:/groupindex.jsp";
	}
}
