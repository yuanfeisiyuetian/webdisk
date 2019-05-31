package com.webcloud.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcloud.biz.FileforusrBiz;
import com.webcloud.dao.FileforusrMapper;
import com.webcloud.entity.Fileforusr;

@Service(value="FileforusrBiz")
public class FileforusrBizImpl implements FileforusrBiz {

	@Autowired
	private FileforusrMapper fileforusrMapper;
	
	public FileforusrMapper getFileforusrMapper() {
		return fileforusrMapper;
	}
	public void setFileforusrMapper(FileforusrMapper fileforusrMapper) {
		this.fileforusrMapper = fileforusrMapper;
	}
	
	@Override
	public List<Fileforusr> selectByUid(Integer uid) {
		// TODO Auto-generated method stub
		return fileforusrMapper.selectByUid(uid);
	}
	@Override
	public List<Fileforusr> selectByUidr(Integer uid) {
		// TODO Auto-generated method stub
		return fileforusrMapper.selectByUidr(uid);
	}
	@Override
	public int uploadFile(Fileforusr fileforusr) {
		// TODO Auto-generated method stub
		return fileforusrMapper.insert(fileforusr);
	}
	@Override
	public Fileforusr selectByUfileID(Integer ufileid) {
		// TODO Auto-generated method stub
		return fileforusrMapper.selectByUfileID(ufileid);
	}
	@Override
	public int updateFile(Fileforusr fileforusr) {
		// TODO Auto-generated method stub
		return fileforusrMapper.updateByPrimaryKey(fileforusr);
	}
	@Override
	public int deletefile(Fileforusr fileforusr) {
		// TODO Auto-generated method stub
		return fileforusrMapper.deleteByPrimaryKey(fileforusr);
	}
	@Override
	public List<Fileforusr> selectByName(Fileforusr fileforusr) {
		// TODO Auto-generated method stub
		return fileforusrMapper.selectByFileName(fileforusr);
	}
	

	
}
