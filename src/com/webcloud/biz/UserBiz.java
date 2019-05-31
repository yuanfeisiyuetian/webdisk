package com.webcloud.biz;

import java.util.List;

import com.webcloud.entity.User;

public interface UserBiz {
	//µÇÂ½
	public User findLoginUser(User user);
	
	//×¢²á
	public int insertUser(User user);
	//×¢²á²éÑ¯
	public User isregsited(User user);
	
	public User selectByUid(Integer uid);
	
	public List<User> selectByname(User user);
	
	public int update(User user);
	
	public List<User> showalluser();
	
	public int deleteusr(Integer uid);
}
