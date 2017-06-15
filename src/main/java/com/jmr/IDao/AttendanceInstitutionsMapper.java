package com.jmr.IDao;

import com.jmr.model.AttendanceInstitutions;

public interface AttendanceInstitutionsMapper {
    int deleteByPrimaryKey(Integer institutionsId);

    int insert(AttendanceInstitutions record);

    int insertSelective(AttendanceInstitutions record);

    AttendanceInstitutions selectByPrimaryKey(Integer institutionsId);

    int updateByPrimaryKeySelective(AttendanceInstitutions record);

    int updateByPrimaryKey(AttendanceInstitutions record);
}