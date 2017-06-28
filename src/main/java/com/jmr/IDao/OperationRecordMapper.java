package com.jmr.IDao;

import com.jmr.model.OperationRecord;

public interface OperationRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(OperationRecord record);

    int insertSelective(OperationRecord record);

    OperationRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(OperationRecord record);

    int updateByPrimaryKey(OperationRecord record);
}