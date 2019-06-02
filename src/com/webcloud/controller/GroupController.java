package com.webcloud.controller;

import java.util.ArrayList;
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

import com.webcloud.biz.GroupBiz;
import com.webcloud.biz.GroupjoinBiz;
import com.webcloud.biz.GroupmanageBiz;
import com.webcloud.biz.UserBiz;
import com.webcloud.entity.Group;
import com.webcloud.entity.Joinin;
import com.webcloud.entity.JoininKey;
import com.webcloud.entity.Manage;
import com.webcloud.entity.ManageKey;
import com.webcloud.entity.User;

@Controller
@RequestMapping("group")
public class GroupController {
	@Autowired
	private GroupjoinBiz groupjoinBiz;
	
	@Autowired
	private GroupmanageBiz groupmanageBiz;
	
	@Autowired
	private GroupBiz groupBiz;
	
	@Autowired
	private UserBiz userBiz;
	
	@RequestMapping(value="init")
	public String init(Map map1,Map map2,Map map3,HttpSession session){
		int uid = (Integer)session.getAttribute("uid");
		List<Group> groupjoinList = groupjoinBiz.selectByUid(uid);
		List<Group> groupmanageList = groupmanageBiz.selectByUid(uid);
		List<Group> groupownList = groupBiz.selectByOid(uid);
		try{	//捕捉没有文件报错异常
			System.out.println(groupjoinList.get(0).getGname());
			System.out.println(groupmanageList.get(0).getGname());
			System.out.println(groupownList.get(0).getGname());
		}catch(Exception e){
			e.printStackTrace();
		}
		map1.put("groupjoinList", groupjoinList);
		map2.put("groupmanageList", groupmanageList);
		map3.put("groupownList", groupownList);
		return "forward:/group.jsp";
	}
	
	@RequestMapping(value="create")
	public String create(Group group,HttpServletRequest request,HttpSession session){
		int uid = (Integer)session.getAttribute("uid");
		group.setOid(uid);
		group.setSetuptime(new Date());
		String token = generateWord();
		Group groupsametoken = groupBiz.selectbyToken(token);
		//确保口令不重复
		while(groupsametoken!=null){
			token = generateWord();
			groupsametoken = groupBiz.selectbyToken(token);
		}
		group.setToken(token);
		groupBiz.insertGroup(group);
		Group logingroup = groupBiz.selectbyToken(token);
		
		session.setAttribute("gid", logingroup.getGid());
		session.setAttribute("group", logingroup);
		
		return "redirect:/groupfile/init.do";
	}
	
	//生成6位群组口令
	private String generateWord() {
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb=new StringBuilder(6);
		for(int i=0;i<6;i++){     
			char ch=str.charAt(new Random().nextInt(str.length()));   
			sb.append(ch);
		}
		return sb.toString();
	}
		 
	//加入群
	@RequestMapping(value="join")
	public String join(String token,HttpServletRequest request,HttpSession session){
		Group group = groupBiz.selectbyToken(token);
		int gid = group.getGid();
		int uid = (int) session.getAttribute("uid");
		JoininKey joininkey = new JoininKey();
		joininkey.setGid(gid);
		joininkey.setUid(uid);
		Joinin joinin = new Joinin();
		joinin.setGid(gid);
		joinin.setUid(uid);
		joinin.setOdiauth(group.getUauth());
		joinin.setDate(new Date());
		groupjoinBiz.insertjoinin(joinin);
		session.setAttribute("gid", group.getGid());
		session.setAttribute("group", group);
		return "redirect:/groupfile/init.do";
	}
	
	
	//管理群
	@RequestMapping(value="manage")
	public String manage(HttpSession session,Map map1,Map map2){
		int gid = (int) session.getAttribute("gid");
		//列出管理员
		List<Manage> managelist = groupmanageBiz.showmanager(gid);
		List<User> managers = new ArrayList<User>();
		try{
			for(int i=0;i<managelist.size();i++){
				managers.add(userBiz.selectByUid(managelist.get(i).getUid()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		map1.put("managers", managers);
		//列出普通用户
		List<Joinin> joinlist = groupjoinBiz.showuser(gid);
		List<User> users = new ArrayList<User>();
		try{
			for(int i=0;i<joinlist.size();i++){
				users.add(userBiz.selectByUid(joinlist.get(i).getUid()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		map2.put("users", users);
		return "forward:/groupuser.jsp";
	}
	
	//修改默认权限
	@RequestMapping(value="set")
	public String set(Group group,HttpSession session){
		int gid = (int) session.getAttribute("gid");
		Group groupold = (Group)session.getAttribute("group");
		group.setGid(gid);
		group.setSetuptime(groupold.getSetuptime());
		group.setToken(groupold.getToken());
		group.setOid((int)session.getAttribute("uid"));
		session.setAttribute("group", group);
		groupBiz.update(group);
		return "redirect:/group/manage.do";
	}
	
	//设置管理
	@RequestMapping(value="manageset")
	public String manageset(HttpServletRequest request,HttpSession session){
		int uid = Integer.parseInt(request.getParameter("key"));
		int gid = (int) session.getAttribute("gid");
		JoininKey joininkey = new JoininKey();
		joininkey.setGid(gid);
		joininkey.setUid(uid);
		groupjoinBiz.deletejoinin(joininkey);
		Manage manager = new Manage();
		manager.setGid(gid);
		manager.setUid(uid);
		manager.setManagerauth(groupBiz.selectByGid(gid).getManagerauth());
		groupmanageBiz.insertmanager(manager);
		return "redirect:/group/manage.do";
	}
	
	//取消管理
	@RequestMapping(value="managereset")
	public String managereset(HttpServletRequest request,HttpSession session){
		int uid = Integer.parseInt(request.getParameter("key"));
		int gid = (int) session.getAttribute("gid");
		ManageKey managekey = new ManageKey();
		managekey.setGid(gid);
		managekey.setUid(uid);
		groupmanageBiz.deletemanage(managekey);
		Joinin joinin = new Joinin();
		joinin.setGid(gid);
		joinin.setUid(uid);
		joinin.setOdiauth(groupBiz.selectByGid(gid).getUauth());
		joinin.setDate(new Date());
		groupjoinBiz.insertjoinin(joinin);
		return "redirect:/group/manage.do";
	}
	
	//移出群聊
	@RequestMapping(value="removemanage")
	public String removemanage(HttpServletRequest request,HttpSession session){
		int uid = Integer.parseInt(request.getParameter("key"));
		int gid = (int) session.getAttribute("gid");
		ManageKey managekey = new ManageKey();
		managekey.setGid(gid);
		managekey.setUid(uid);
		groupmanageBiz.deletemanage(managekey);
		return "redirect:/group/manage.do";
	}
	
	@RequestMapping(value="removeuser")
	public String removeuser(HttpServletRequest request,HttpSession session){
		int uid = Integer.parseInt(request.getParameter("key"));
		int gid = (int) session.getAttribute("gid");
		JoininKey joininkey = new JoininKey();
		joininkey.setGid(gid);
		joininkey.setUid(uid);
		groupjoinBiz.deletejoinin(joininkey);
		return "redirect:/group/manage.do";
	}
	
	@RequestMapping(value="quitmanage")
	public String quitmanage(HttpSession session,HttpServletRequest request){
		int gid = Integer.parseInt(request.getParameter("key"));
		int uid = (int)session.getAttribute("uid");
		ManageKey managekey = new ManageKey();
		managekey.setGid(gid);
		managekey.setUid(uid);
		groupmanageBiz.deletemanage(managekey);
		return "redirect:/group/init.do";
	}
	
	@RequestMapping(value="quitgroup")
	public String quitgroup(HttpSession session,HttpServletRequest request){
		int gid = Integer.parseInt(request.getParameter("key"));
		int uid = (int)session.getAttribute("uid");
		JoininKey joininkey = new JoininKey();
		joininkey.setGid(gid);
		joininkey.setUid(uid);
		groupjoinBiz.deletejoinin(joininkey);
		return "redirect:/group/init.do";
	}
	
	@RequestMapping(value="searchuser")
	public String searchuser(Map map1,Map map2,HttpSession session,String uname){
		int gid = (int) session.getAttribute("gid");
		User user = new User();
		user.setUname(uname);
		List<User> userlist = userBiz.selectByname(user);
		List<Manage> managerlist = groupmanageBiz.showmanager(gid);
		List<Joinin> joinlist = groupjoinBiz.showuser(gid);
		try{
			for(int i=0;i<userlist.size();i++){
			if(!managerlist.contains(groupmanageBiz.selectByUid(userlist.get(i).getUid())))
				managerlist.remove(i);
			}
			for(int i=0;i<userlist.size();i++){
				if(!joinlist.contains(groupjoinBiz.selectByUid(userlist.get(i).getUid())))
					joinlist.remove(i);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		map1.put("managers", managerlist);
		map2.put("users", joinlist);
		return "forward:/groupuser.jsp";
	}
}
