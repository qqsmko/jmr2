package com.jmr.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.InstitutionsVerify;
import com.jmr.model.InstitutionsVerifyKey;

public interface InstitutionsVerifyMapper {
    int deleteByPrimaryKey(InstitutionsVerifyKey key);

    int insert(InstitutionsVerify record);

    int insertSelective(InstitutionsVerify record);

    InstitutionsVerify selectByPrimaryKey(InstitutionsVerifyKey key);

    List<InstitutionsVerify> selectByPage(@Param("start")int start,@Param("length")int length);
    
    int selectCount();
    
    int updateByPrimaryKeySelective(InstitutionsVerify record);

    int updateByPrimaryKey(InstitutionsVerify record);
}