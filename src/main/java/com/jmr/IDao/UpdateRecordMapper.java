package com.jmr.IDao;

import com.jmr.model.UpdateRecord;

public interface UpdateRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(UpdateRecord record);

    int insertSelective(UpdateRecord record);

    UpdateRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(UpdateRecord record);

    int updateByPrimaryKey(UpdateRecord record);
}