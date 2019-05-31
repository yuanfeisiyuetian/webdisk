package com.webcloud.dao;

import java.util.List;

import com.webcloud.entity.Fileforusr;
import com.webcloud.entity.FileforusrKey;

public interface FileforusrMapper {
    int deleteByPrimaryKey(FileforusrKey key);

    int insert(Fileforusr record);

    int insertSelective(Fileforusr record);

    Fileforusr selectByPrimaryKey(FileforusrKey key);

    int updateByPrimaryKeySelective(Fileforusr record);

    int updateByPrimaryKey(Fileforusr record);
    
    //查询文件
    public List<Fileforusr> selectByFileName(Fileforusr record);
    
    //根据用户id显示文件列表
    public List<Fileforusr> selectByUid(Integer uid);
    
    //根据用户id显示回收文件
    public List<Fileforusr> selectByUidr(Integer uid);
    
    //根据文件id
    public Fileforusr selectByUfileID(Integer ufileid);
}