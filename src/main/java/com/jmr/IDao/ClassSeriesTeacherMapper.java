package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.ClassSeriesTeacher;
import com.jmr.model.ClassSeriesTeacherKey;

public interface ClassSeriesTeacherMapper {
    int deleteByPrimaryKey(ClassSeriesTeacherKey key);

    int insert(ClassSeriesTeacher record);

    int insertSelective(ClassSeriesTeacher record);

    ClassSeriesTeacher selectByPrimaryKey(ClassSeriesTeacherKey key);
    
    List<ClassSeriesTeacher> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();

    int updateByPrimaryKeySelective(ClassSeriesTeacher record);

    int updateByPrimaryKey(ClassSeriesTeacher record);
}