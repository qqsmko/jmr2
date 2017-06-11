package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.ClassClassSeries;
import com.jmr.model.ClassClassSeriesKey;

public interface ClassClassSeriesMapper {
    int deleteByPrimaryKey(ClassClassSeriesKey key);

    int insert(ClassClassSeries record);

    int insertSelective(ClassClassSeries record);

    ClassClassSeries selectByPrimaryKey(ClassClassSeriesKey key);
    
    List<ClassClassSeries> selectByPage(@Param("start")int start,@Param("length")int length);

    int selectCount();
    
    int updateByPrimaryKeySelective(ClassClassSeries record);

    int updateByPrimaryKey(ClassClassSeries record);
}