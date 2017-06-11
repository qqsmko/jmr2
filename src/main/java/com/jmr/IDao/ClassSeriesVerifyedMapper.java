package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.ClassSeriesVerifyed;

public interface ClassSeriesVerifyedMapper {
    int deleteByPrimaryKey(Integer classSeriesId);

    int insert(ClassSeriesVerifyed record);

    int insertSelective(ClassSeriesVerifyed record);

    ClassSeriesVerifyed selectByPrimaryKey(Integer classSeriesId);
    
    List<ClassSeriesVerifyed> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();

    int updateByPrimaryKeySelective(ClassSeriesVerifyed record);

    int updateByPrimaryKey(ClassSeriesVerifyed record);
}