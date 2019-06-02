package com.webcloud.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcloud.biz.GroupBiz;
import com.webcloud.dao.GroupMapper;
import com.webcloud.entity.Group;

@Service(value="GroupBiz")
public class GroupBizImpl implements GroupBiz {
	
	@Autowired
	private GroupMapper groupMapper;
	
	
	public GroupMapper getGroupMapper() {
		return groupMapper;
	}


	public void setGroupMapper(GroupMapper groupMapper) {
		this.groupMapper = groupMapper;
	}


	@Override
	public List<Group> selectByOid(Integer oid) {
		// TODO Auto-generated method stub
		return groupMapper.selectByOid(oid);
	}


	@Override
	public Group selectbyToken(String token) {
		// TODO Auto-generated method stub
		return groupMapper.selectByToken(token);
	}


	@Override
	public int insertGroup(Group group) {
		// TODO Auto-generated method stub
		return groupMapper.insert(group);
	}


	@Override
	public Group selectByGid(Integer gid) {
		// TODO Auto-generated method stub
		return groupMapper.selectByPrimaryKey(gid);
	}


	@Override
	public int update(Group group) {
		// TODO Auto-generated method stub
		return groupMapper.updateByPrimaryKey(group);
	}


	@Override
	public int delete(Integer gid) {
		// TODO Auto-generated method stub
		return groupMapper.deleteByPrimaryKey(gid);
	}




}
