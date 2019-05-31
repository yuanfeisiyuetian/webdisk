package com.webcloud.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcloud.biz.UserBiz;
import com.webcloud.dao.UserMapper;
import com.webcloud.entity.User;

@Service(value="userBiz")
public class UserBizImpl implements UserBiz {

	@Autowired
	private UserMapper userMapper;

	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	//µÇÂ½
	@Override
	public User findLoginUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectLoginUser(user);
	}
	
	//×¢²á
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}

	//ÑéÖ¤email·ÀÖ¹ÖØ¸´×¢²á
	@Override
	public User isregsited(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectbyEmail(user);
	}

	@Override
	public User selectByUid(Integer uid) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public List<User> selectByname(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectByUName(user);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public List<User> showalluser() {
		// TODO Auto-generated method stub
		return userMapper.select();
	}

	@Override
	public int deleteusr(Integer uid) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(uid);
	}


	
}
