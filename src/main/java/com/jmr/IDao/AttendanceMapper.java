package com.jmr.IDao;

import com.jmr.model.Attendance;
import com.jmr.model.AttendanceKey;

public interface AttendanceMapper {
    int deleteByPrimaryKey(AttendanceKey key);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(AttendanceKey key);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
}