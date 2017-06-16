package com.jmr.IDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.Class;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer classId);
    
    List<Class> selectByPage(@Param("start")int start,@Param("length")int length);
    
    List<Map<String, Object>> selectByPageSQL(@Param("start")int start,@Param("length")int length);
    
    List<Map<String, Object>> selectByPageWithId(@Param("start")int start,@Param("length")int length,@Param("id")int id);
    
    int selectCount();

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}