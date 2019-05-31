package com.webcloud.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcloud.biz.FileforgruBiz;
import com.webcloud.dao.FileforgruMapper;
import com.webcloud.entity.Fileforgru;

@Service(value="FileforgruBiz")
public class FileforgruBizImpl implements FileforgruBiz {
	
	@Autowired
	private FileforgruMapper fileforgruMapper;
	
	public FileforgruMapper getFileforgruMapper() {
		return fileforgruMapper;
	}

	public void setFileforgruMapper(FileforgruMapper fileforgruMapper) {
		this.fileforgruMapper = fileforgruMapper;
	}

	@Override
	public List<Fileforgru> selectByGid(Integer gid) {
		// TODO Auto-generated method stub
		return fileforgruMapper.selectByGid(gid);
	}

	@Override
	public int uploadFile(Fileforgru fileforgru) {
		// TODO Auto-generated method stub
		return fileforgruMapper.insert(fileforgru);
	}

	@Override
	public Fileforgru selectByGFileid(Integer gfileid) {
		// TODO Auto-generated method stub
		return fileforgruMapper.selectByGFileid(gfileid);
	}

	@Override
	public int updateFile(Fileforgru fileforgru) {
		// TODO Auto-generated method stub
		return fileforgruMapper.updateByPrimaryKey(fileforgru);
	}

	@Override
	public List<Fileforgru> selectByGidr(Integer gid) {
		// TODO Auto-generated method stub
		return fileforgruMapper.selectByGidr(gid);
	}

	@Override
	public int deletefile(Fileforgru fileforgru) {
		// TODO Auto-generated method stub
		return fileforgruMapper.deleteByPrimaryKey(fileforgru);
	}

	@Override
	public List<Fileforgru> selectByGName(Fileforgru fileforgru) {
		// TODO Auto-generated method stub
		return fileforgruMapper.selectByGFileName(fileforgru);
	}
	
}
