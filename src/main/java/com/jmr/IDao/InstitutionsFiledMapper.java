package com.jmr.IDao;

import com.jmr.model.InstitutionsFiled;

public interface InstitutionsFiledMapper {
    int deleteByPrimaryKey(Integer institutionsId);

    int insert(InstitutionsFiled record);

    int insertSelective(InstitutionsFiled record);

    InstitutionsFiled selectByPrimaryKey(Integer institutionsId);

    int updateByPrimaryKeySelective(InstitutionsFiled record);

    int updateByPrimaryKey(InstitutionsFiled record);
}