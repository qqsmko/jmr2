package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.ClassSeriesCourse;
import com.jmr.model.ClassSeriesCourseKey;

public interface ClassSeriesCourseMapper {
    int deleteByPrimaryKey(ClassSeriesCourseKey key);

    int insert(ClassSeriesCourse record);

    int insertSelective(ClassSeriesCourse record);

    ClassSeriesCourse selectByPrimaryKey(ClassSeriesCourseKey key);
    
    List<ClassSeriesCourse> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();

    int updateByPrimaryKeySelective(ClassSeriesCourse record);

    int updateByPrimaryKey(ClassSeriesCourse record);
}