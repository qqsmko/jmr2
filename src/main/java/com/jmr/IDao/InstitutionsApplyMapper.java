package com.jmr.IDao;

import com.jmr.model.InstitutionsApply;

public interface InstitutionsApplyMapper {
    int deleteByPrimaryKey(String applyEmail);

    int insert(InstitutionsApply record);

    int insertSelective(InstitutionsApply record);

    InstitutionsApply selectByPrimaryKey(String applyEmail);

    int updateByPrimaryKeySelective(InstitutionsApply record);

    int updateByPrimaryKey(InstitutionsApply record);
}