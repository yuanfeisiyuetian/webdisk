package com.webcloud.controller;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webcloud.biz.UserBiz;
import com.webcloud.entity.User;

@Controller
@RequestMapping(value="user")
public class UserController {
	@Autowired
	private UserBiz userBiz;
	
	@RequestMapping(value="login")
	public String login(HttpSession session,User user,Map map){
		User loginuser = userBiz.findLoginUser(user);
		session.removeAttribute("msg");
		if(loginuser==null){
			session.setAttribute("msg","用户名和密码错误");
			return "login";
		}
		
		session.setAttribute("loginuser", loginuser);
		session.setAttribute("uid", loginuser.getUid());
		
		if(user.getUemail().equals("admin")&&user.getPasswordhash().equals("admin")){
			session.setAttribute("loginuser", loginuser);
			return "redirect:/user/admin.do";
		}
			
		
		return "redirect:/main/init.do";
	}

	@RequestMapping(value="register")
	public String register(User user,HttpServletRequest request,HttpSession session) throws Exception{
		User reguser = userBiz.isregsited(user);
		session.removeAttribute("msg");
		if(reguser==null&&user!=null){
			user.setUregistertime(new Date());
			userBiz.insertUser(user);
			request.setAttribute("user", user);
			return "redirect:/login.jsp";
		}
		else {
			session.setAttribute("msg","该邮箱已被注册");
			return "redirect:/register.jsp";
		}
	}

	@RequestMapping(value="pwd")
	public String pwd(@RequestParam("password") String pwd,HttpSession session){
		User user = (User)session.getAttribute("loginuser");
		user.setPasswordhash(pwd);
		userBiz.update(user);
		session.setAttribute("msg", "请重新登陆");
		return "login";
	}
	
	@RequestMapping(value="admin")
	public String admin(Map map){
		List<User> userlist = userBiz.showalluser();
		try{
			for(int i=userlist.size()-1;i>=0;i--){
				if(userlist.get(i).getUemail().equals("admin")&&userlist.get(i).getPasswordhash().equals("admin")){
					System.out.println("equal");
					userlist.remove(i);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		map.put("userlist", userlist);
		return "forward:/admin.jsp";
	}
	
	@RequestMapping(value="resetpwd")
	public String resetpwd(HttpServletRequest request,HttpSession session){
		int uid = Integer.parseInt(request.getParameter("key"));
		User user = userBiz.selectByUid(uid);
		user.setPasswordhash(generateWord());
		userBiz.update(user);
		session.setAttribute("msg", user.getUemail()+"的密码重置为"+user.getPasswordhash());
		return "forward:/user/admin.do";
	}
	
	
	//生成六位随机密码
	private String generateWord() {
		 String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		 StringBuilder sb=new StringBuilder(6);
		 for(int i=0;i<6;i++){     
			 char ch=str.charAt(new Random().nextInt(str.length()));   
			 sb.append(ch);
		 }
	      return sb.toString();
	 }
	
	@RequestMapping(value="del")
	public String del(HttpServletRequest request){
		int uid = Integer.parseInt(request.getParameter("key"));
		userBiz.deleteusr(uid);
		return "forward:/user/admin.do";
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session){
		if(session.getAttribute("gid") != null)
			session.removeAttribute("gid");
		if(session.getAttribute("group") != null)
			session.removeAttribute("group");
		if(session.getAttribute("uid") != null)
			session.removeAttribute("uid");
		if(session.getAttribute("loginuser") != null)
			session.removeAttribute("loginuser");
		if(session.getAttribute("file") != null)
			session.removeAttribute("file");
		if(session.getAttribute("filename") != null)
			session.removeAttribute("filename");
		if(session.getAttribute("shareforusr") != null)
			session.removeAttribute("shareforusr");
		if(session.getAttribute("msg") != null)
			session.removeAttribute("msg");
		return "login";
	}
}
