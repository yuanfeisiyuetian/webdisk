package com.webcloud.biz;

import java.util.List;

import com.webcloud.entity.Group;

public interface GroupBiz {
	public List<Group> selectByOid(Integer oid);
	
	public Group selectbyToken(String token);
	
	public int insertGroup(Group group);
	
	public Group selectByGid(Integer gid);
	
	public int update(Group group);
}
