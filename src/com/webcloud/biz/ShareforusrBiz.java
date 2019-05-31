package com.webcloud.biz;

import java.util.List;

import com.webcloud.entity.Fileforusr;
import com.webcloud.entity.Shareforusr;

public interface ShareforusrBiz {

	//显示目前的分享
	public List<Shareforusr> selectByUid(Integer uid);
	
	//新增一条分享
	public int insertshare(Shareforusr Shareforusr);
	
	//查看该文件是否分享过
	public Shareforusr selectByUfileid(Integer ufileid);
	
	//查看分享文件
	public Shareforusr showshare(String uuid);
	
	//删除分享链接
	public int deleteshare(Shareforusr Shareforusr);
}
