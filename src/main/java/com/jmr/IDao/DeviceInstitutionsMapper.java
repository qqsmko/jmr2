package com.jmr.IDao;

import com.jmr.model.DeviceInstitutions;
import com.jmr.model.DeviceInstitutionsKey;

public interface DeviceInstitutionsMapper {
    int deleteByPrimaryKey(DeviceInstitutionsKey key);

    int insert(DeviceInstitutions record);

    int insertSelective(DeviceInstitutions record);

    DeviceInstitutions selectByPrimaryKey(DeviceInstitutionsKey key);

    int updateByPrimaryKeySelective(DeviceInstitutions record);

    int updateByPrimaryKey(DeviceInstitutions record);
}