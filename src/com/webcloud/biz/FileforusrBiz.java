package com.webcloud.biz;

import java.util.List;

import com.webcloud.entity.Fileforusr;

public interface FileforusrBiz {
	//查找个人网盘所含文件
	public List<Fileforusr> selectByUid(Integer uid);
	
	//查看回收站
	public List<Fileforusr> selectByUidr(Integer uid);
	
	//上传文件
	public int uploadFile(Fileforusr fileforusr);
	
	//根据id选择文件
	public Fileforusr selectByUfileID(Integer ufileid);
	
	//更新文件状态
	public int updateFile(Fileforusr fileforusr);
	
	//删除文件
	public int deletefile(Fileforusr fileforusr);
	
	//搜索文件
	public List<Fileforusr> selectByName(Fileforusr fileforusr);
}
