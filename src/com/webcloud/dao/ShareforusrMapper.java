package com.webcloud.dao;

import java.util.List;

import com.webcloud.entity.Shareforusr;
import com.webcloud.entity.ShareforusrKey;

public interface ShareforusrMapper {
    int deleteByPrimaryKey(ShareforusrKey key);

    int insert(Shareforusr record);

    int insertSelective(Shareforusr record);

    Shareforusr selectByPrimaryKey(ShareforusrKey key);

    int updateByPrimaryKeySelective(Shareforusr record);

    int updateByPrimaryKey(Shareforusr record);
    
    //分享列表
    public List<Shareforusr> selectByUid(Integer uid);
    
    //根据文件id查看分享信息
    public Shareforusr selectByUfileid(Integer uid);
    
    //根据uuid查看分享文件
    public Shareforusr selectByToken(String uuid); 
}