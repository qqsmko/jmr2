package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.Idcard;

public interface IdcardMapper {
    int deleteByPrimaryKey(Integer cardId);

    int insert(Idcard record);

    int insertSelective(Idcard record);

    Idcard selectByPrimaryKey(Integer cardId);
    
    List<Idcard> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();

    int updateByPrimaryKeySelective(Idcard record);

    int updateByPrimaryKey(Idcard record);
}