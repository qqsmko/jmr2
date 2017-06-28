package com.jmr.IDao;

import com.jmr.model.Avatar;

public interface AvatarMapper {
    int deleteByPrimaryKey(Integer avatarId);

    int insert(Avatar record);

    int insertSelective(Avatar record);

    Avatar selectByPrimaryKey(Integer avatarId);

    int updateByPrimaryKeySelective(Avatar record);

    int updateByPrimaryKey(Avatar record);
}