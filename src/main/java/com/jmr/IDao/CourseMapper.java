package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);
    
    List<Course> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}