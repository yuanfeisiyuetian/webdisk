package com.webcloud.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcloud.biz.ShareforusrBiz;
import com.webcloud.dao.FileforusrMapper;
import com.webcloud.dao.ShareforusrMapper;
import com.webcloud.entity.Fileforusr;
import com.webcloud.entity.Shareforusr;

@Service(value="ShareforusrBiz")
public class ShareforusrImpl implements ShareforusrBiz {

	@Autowired
	private ShareforusrMapper shareforusrMapper;
	
	@Autowired
	private FileforusrMapper fileforusrMapper;
	
	public ShareforusrMapper getShareforusrMapper() {
		return shareforusrMapper;
	}

	public void setShareforusrMapper(ShareforusrMapper shareforusrMapper) {
		this.shareforusrMapper = shareforusrMapper;
	}

	@Override
	public List<Shareforusr> selectByUid(Integer uid) {
		// TODO Auto-generated method stub
		return shareforusrMapper.selectByUid(uid);
	}

	@Override
	public int insertshare(Shareforusr Shareforusr) {
		// TODO Auto-generated method stub
		return shareforusrMapper.insert(Shareforusr);
	}

	@Override
	public Shareforusr selectByUfileid(Integer ufileid) {
		// TODO Auto-generated method stub
		return shareforusrMapper.selectByUfileid(ufileid);
	}

	@Override
	public Shareforusr showshare(String uuid) {
		// TODO Auto-generated method stub
		return shareforusrMapper.selectByToken(uuid);
	}

	@Override
	public int deleteshare(Shareforusr Shareforusr) {
		// TODO Auto-generated method stub
		return shareforusrMapper.deleteByPrimaryKey(Shareforusr);
	}




	

}
