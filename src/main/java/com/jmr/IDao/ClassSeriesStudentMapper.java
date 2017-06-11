package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.ClassSeriesStudent;
import com.jmr.model.ClassSeriesStudentKey;

public interface ClassSeriesStudentMapper {
    int deleteByPrimaryKey(ClassSeriesStudentKey key);

    int insert(ClassSeriesStudent record);

    int insertSelective(ClassSeriesStudent record);

    ClassSeriesStudent selectByPrimaryKey(ClassSeriesStudentKey key);
    
    List<ClassSeriesStudent> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();

    int updateByPrimaryKeySelective(ClassSeriesStudent record);

    int updateByPrimaryKey(ClassSeriesStudent record);
}