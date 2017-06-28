package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.ClassSeriesCompletion;

public interface ClassSeriesCompletionMapper {
    int deleteByPrimaryKey(Integer classSeriesId);

    int insert(ClassSeriesCompletion record);

    int insertSelective(ClassSeriesCompletion record);

    ClassSeriesCompletion selectByPrimaryKey(Integer classSeriesId);
    
    List<ClassSeriesCompletion> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();

    int updateByPrimaryKeySelective(ClassSeriesCompletion record);

    int updateByPrimaryKey(ClassSeriesCompletion record);
}