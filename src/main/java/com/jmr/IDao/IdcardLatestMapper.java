package com.jmr.IDao;

import com.jmr.model.IdcardLatest;

public interface IdcardLatestMapper {
    int deleteByPrimaryKey(Integer cardId);

    int insert(IdcardLatest record);

    int insertSelective(IdcardLatest record);

    IdcardLatest selectByPrimaryKey(Integer cardId);

    int updateByPrimaryKeySelective(IdcardLatest record);

    int updateByPrimaryKey(IdcardLatest record);
}