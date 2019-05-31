package com.webcloud.biz;

import java.util.List;

import com.webcloud.entity.Fileforgru;

public interface FileforgruBiz {
	public List<Fileforgru> selectByGid(Integer gid);
	
	public int uploadFile(Fileforgru fileforgru);
	
	public Fileforgru selectByGFileid(Integer gfileid);
	
	public int updateFile(Fileforgru fileforgru);
	
	public List<Fileforgru> selectByGidr(Integer gid);
	
	public int deletefile(Fileforgru fileforgru);
	
	public List<Fileforgru> selectByGName(Fileforgru fileforgru);
}
