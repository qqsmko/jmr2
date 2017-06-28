package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.ClassSeriesVerify;

public interface ClassSeriesVerifyMapper {
    int deleteByPrimaryKey(Integer classSeriesId);

    int insert(ClassSeriesVerify record);

    int insertSelective(ClassSeriesVerify record);

    ClassSeriesVerify selectByPrimaryKey(Integer classSeriesId);
    
    List<ClassSeriesVerify> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();

    int updateByPrimaryKeySelective(ClassSeriesVerify record);

    int updateByPrimaryKey(ClassSeriesVerify record);
}