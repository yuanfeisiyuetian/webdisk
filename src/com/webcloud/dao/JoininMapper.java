package com.webcloud.dao;

import java.util.List;

import com.webcloud.entity.Joinin;
import com.webcloud.entity.JoininKey;

public interface JoininMapper {
    int deleteByPrimaryKey(JoininKey key);

    int insert(Joinin record);

    int insertSelective(Joinin record);

    Joinin selectByPrimaryKey(JoininKey key);

    int updateByPrimaryKeySelective(Joinin record);

    int updateByPrimaryKey(Joinin record);
    
    public List<Joinin> selectByUid(Integer uid);
    
    public List<Joinin> selectByGid(Integer gid);
}