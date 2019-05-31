package com.webcloud.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcloud.biz.GroupmanageBiz;
import com.webcloud.dao.GroupMapper;
import com.webcloud.dao.ManageMapper;
import com.webcloud.entity.Group;
import com.webcloud.entity.Manage;
import com.webcloud.entity.ManageKey;

@Service(value="GroupmanageBiz")
public class GroupmanageBizImpl implements GroupmanageBiz {

	@Autowired
	private GroupMapper groupMapper;
	
	@Autowired
	private ManageMapper manageMapper;
	
	
	public GroupMapper getGroupMapper() {
		return groupMapper;
	}


	public void setGroupMapper(GroupMapper groupMapper) {
		this.groupMapper = groupMapper;
	}


	public ManageMapper getManageMapper() {
		return manageMapper;
	}


	public void setManageMapper(ManageMapper manageMapper) {
		this.manageMapper = manageMapper;
	}


	//我管理的群组
	@Override
	public List<Group> selectByUid(Integer uid) {
		// TODO Auto-generated method stub
		List<Manage> joininlist = manageMapper.selectByUid(uid);
		List<Group> grouplist = new ArrayList<Group>();
		for(int i=0;i<joininlist.size();i++){
			Group group = groupMapper.selectByPrimaryKey(joininlist.get(i).getGid());
			grouplist.add(group);
		}
		return grouplist;
	}


	@Override
	public List<Manage> showmanager(Integer gid) {
		// TODO Auto-generated method stub
		return manageMapper.selectByGid(gid);
	}


	@Override
	public int insertmanager(Manage manage) {
		// TODO Auto-generated method stub
		return manageMapper.insert(manage);
	}


	@Override
	public int deletemanage(ManageKey key) {
		// TODO Auto-generated method stub
		return manageMapper.deleteByPrimaryKey(key);
	}

}
