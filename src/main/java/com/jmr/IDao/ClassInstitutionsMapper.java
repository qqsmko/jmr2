package com.jmr.IDao;

import com.jmr.model.ClassInstitutions;

public interface ClassInstitutionsMapper {
    int deleteByPrimaryKey(Integer institutionsId);

    int insert(ClassInstitutions record);

    int insertSelective(ClassInstitutions record);

    ClassInstitutions selectByPrimaryKey(Integer institutionsId);

    int updateByPrimaryKeySelective(ClassInstitutions record);

    int updateByPrimaryKey(ClassInstitutions record);
}