package com.webcloud.dao;

import java.util.List;

import com.webcloud.entity.Group;

public interface GroupMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
    
    public List<Group> selectByOid(Integer oid);

    public Group selectByToken(String token);
}