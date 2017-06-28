package com.jmr.IDao;

import com.jmr.model.VerifyRecord;

public interface VerifyRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(VerifyRecord record);

    int insertSelective(VerifyRecord record);

    VerifyRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(VerifyRecord record);

    int updateByPrimaryKey(VerifyRecord record);
}