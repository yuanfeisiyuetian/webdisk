package com.webcloud.dao;

import java.util.List;

import com.webcloud.entity.Manage;
import com.webcloud.entity.ManageKey;

public interface ManageMapper {
    int deleteByPrimaryKey(ManageKey key);

    int insert(Manage record);

    int insertSelective(Manage record);

    Manage selectByPrimaryKey(ManageKey key);

    int updateByPrimaryKeySelective(Manage record);

    int updateByPrimaryKey(Manage record);
    
    public List<Manage> selectByUid(Integer uid);
    
    public List<Manage> selectByGid(Integer gid);
}