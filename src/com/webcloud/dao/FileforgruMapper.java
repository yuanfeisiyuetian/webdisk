package com.webcloud.dao;

import java.util.List;

import com.webcloud.entity.Fileforgru;
import com.webcloud.entity.FileforgruKey;
import com.webcloud.entity.Fileforusr;

public interface FileforgruMapper {
    int deleteByPrimaryKey(FileforgruKey key);

    int insert(Fileforgru record);

    int insertSelective(Fileforgru record);

    Fileforgru selectByPrimaryKey(FileforgruKey key);

    int updateByPrimaryKeySelective(Fileforgru record);

    int updateByPrimaryKey(Fileforgru record);
    
    public List<Fileforgru> selectByGid(Integer gid);
    
    public Fileforgru selectByGFileid(Integer gfileid);
    
    public List<Fileforgru> selectByGidr(Integer gid);
    
    public List<Fileforgru> selectByGFileName(Fileforgru record);
}