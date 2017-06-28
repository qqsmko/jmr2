package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.CourseInstitutions;
import com.jmr.model.CourseInstitutionsKey;

public interface CourseInstitutionsMapper {
    int deleteByPrimaryKey(CourseInstitutionsKey key);

    int insert(CourseInstitutions record);

    int insertSelective(CourseInstitutions record);

    CourseInstitutions selectByPrimaryKey(CourseInstitutionsKey key);
    
    List<CourseInstitutions> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();

    int updateByPrimaryKeySelective(CourseInstitutions record);

    int updateByPrimaryKey(CourseInstitutions record);
}