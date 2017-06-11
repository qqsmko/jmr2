package com.jmr.IDao;

import com.jmr.model.AttendanceDetail;

public interface AttendanceDetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(AttendanceDetail record);

    int insertSelective(AttendanceDetail record);

    AttendanceDetail selectByPrimaryKey(Integer detailId);

    int updateByPrimaryKeySelective(AttendanceDetail record);

    int updateByPrimaryKey(AttendanceDetail record);
}