package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.ClassSeries;

public interface ClassSeriesMapper {
    int deleteByPrimaryKey(Integer classSeriesId);

    int insert(ClassSeries record);

    int insertSelective(ClassSeries record);

    ClassSeries selectByPrimaryKey(Integer classSeriesId);
    
    List<ClassSeries> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();

    int updateByPrimaryKeySelective(ClassSeries record);

    int updateByPrimaryKey(ClassSeries record);
}