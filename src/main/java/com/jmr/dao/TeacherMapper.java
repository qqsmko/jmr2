package com.jmr.dao;

import com.jmr.model.Teacher;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherid);
    
    List<Teacher> selectAll();

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    int softDelete(Integer teacherid);
    
    List<Teacher> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();
}