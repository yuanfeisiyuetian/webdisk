package com.webcloud.biz;

import java.util.List;

import com.webcloud.entity.Group;
import com.webcloud.entity.Manage;
import com.webcloud.entity.ManageKey;

public interface GroupmanageBiz {

	public List<Group> selectByUid(Integer uid);
	
	public List<Manage> showmanager(Integer gid);
	
	public int insertmanager(Manage manage);
	
	public int deletemanage(ManageKey key);
}
