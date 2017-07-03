package com.jmr.IDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.StudentInfo;
import com.jmr.model.StudentInfoKey;

public interface StudentInfoMapper {
    int deleteByPrimaryKey(StudentInfoKey key);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(StudentInfoKey key);

    List<Map<String, Object>> selectByPageSQL(@Param("start")int start,@Param("length")int length);

    List<Map<String, Object>> selectByPageWithName(@Param("start")int start,@Param("length")int length,@Param("search")String search);
    
    int selectCount();
    
    int selectFilteredCount(String search);
    
    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}