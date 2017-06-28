package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.Institutions;

public interface InstitutionsMapper {
    int deleteByPrimaryKey(Integer institutionsId);

    int insert(Institutions record);

    int insertSelective(Institutions record);

    Institutions selectByPrimaryKey(Integer institutionsId);
    
    List<Institutions> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();

    int updateByPrimaryKeySelective(Institutions record);

    int updateByPrimaryKey(Institutions record);
    
    List<Institutions> selectAll();
}