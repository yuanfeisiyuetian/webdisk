package com.webcloud.biz;

import java.util.List;

import com.webcloud.entity.Group;
import com.webcloud.entity.Joinin;
import com.webcloud.entity.JoininKey;

public interface GroupjoinBiz {
	
	public List<Group> selectByUid(Integer uid);
	
	public Joinin selectByKey(JoininKey key);
	
	public int insertjoinin(Joinin joinin);
	
	public List<Joinin> showuser(Integer gid);
	
	public int deletejoinin(JoininKey key);
}
