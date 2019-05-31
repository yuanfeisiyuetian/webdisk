package com.webcloud.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcloud.biz.GroupjoinBiz;
import com.webcloud.dao.GroupMapper;
import com.webcloud.dao.JoininMapper;
import com.webcloud.entity.Group;
import com.webcloud.entity.Joinin;
import com.webcloud.entity.JoininKey;

@Service(value="GroupjoinBiz")
public class GroupjoinBizImpl implements GroupjoinBiz {
	
	@Autowired
	private GroupMapper groupMapper;
	
	@Autowired
	private JoininMapper joinMapper;
	
	public GroupMapper getGroupMapper() {
		return groupMapper;
	}

	public void setGroupMapper(GroupMapper groupMapper) {
		this.groupMapper = groupMapper;
	}

	public JoininMapper getJoinMapper() {
		return joinMapper;
	}

	public void setJoinMapper(JoininMapper joinMapper) {
		this.joinMapper = joinMapper;
	}



	//我加入的群组
	@Override
	public List<Group> selectByUid(Integer uid) {
		// TODO Auto-generated method stub
		List<Joinin> joininlist = joinMapper.selectByUid(uid);
		List<Group> grouplist = new ArrayList<Group>();
		for(int i=0;i<joininlist.size();i++){
			Group group = groupMapper.selectByPrimaryKey(joininlist.get(i).getGid());
			grouplist.add(group);
		}
		return grouplist;
	}

	@Override
	public Joinin selectByKey(JoininKey key) {
		// TODO Auto-generated method stub
		return joinMapper.selectByPrimaryKey(key);
	}

	@Override
	public int insertjoinin(Joinin joinin) {
		// TODO Auto-generated method stub
		return joinMapper.insert(joinin);
	}

	@Override
	public List<Joinin> showuser(Integer gid) {
		// TODO Auto-generated method stub
		return joinMapper.selectByGid(gid);
	}

	@Override
	public int deletejoinin(JoininKey key) {
		// TODO Auto-generated method stub
		return joinMapper.deleteByPrimaryKey(key);
	}



}
