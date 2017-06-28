package com.jmr.IDao;

import com.jmr.model.AttendanceStatistics;

public interface AttendanceStatisticsMapper {
    int deleteByPrimaryKey(Integer statisticsId);

    int insert(AttendanceStatistics record);

    int insertSelective(AttendanceStatistics record);

    AttendanceStatistics selectByPrimaryKey(Integer statisticsId);

    int updateByPrimaryKeySelective(AttendanceStatistics record);

    int updateByPrimaryKey(AttendanceStatistics record);
}