package com.jmr.IDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.TeacherInfo;
import com.jmr.model.TeacherInfoKey;

public interface TeacherInfoMapper {
    int deleteByPrimaryKey(TeacherInfoKey key);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    TeacherInfo selectByPrimaryKey(TeacherInfoKey key);
    
    List<Map<String, Object>> selectByPageSQL(@Param("start")int start,@Param("length")int length);

    List<Map<String, Object>> selectByPageWithName(@Param("start")int start,@Param("length")int length,@Param("search")String search);
    
    int selectCount();
    
    int selectFilteredCount(String search);
    
    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);
}