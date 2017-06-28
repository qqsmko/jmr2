package com.jmr.IDao;

import com.jmr.model.InstitutionsPrepare;

public interface InstitutionsPrepareMapper {
    int deleteByPrimaryKey(Integer institutionsId);

    int insert(InstitutionsPrepare record);

    int insertSelective(InstitutionsPrepare record);

    InstitutionsPrepare selectByPrimaryKey(Integer institutionsId);

    int updateByPrimaryKeySelective(InstitutionsPrepare record);

    int updateByPrimaryKey(InstitutionsPrepare record);
}