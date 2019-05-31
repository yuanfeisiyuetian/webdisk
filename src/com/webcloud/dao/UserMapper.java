package com.webcloud.dao;

import java.util.List;

import com.webcloud.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    public User selectLoginUser(User user);
    
    public User selectbyEmail(User user);
    
    public List<User> selectByUName(User record);
    
    public List<User> select();
}