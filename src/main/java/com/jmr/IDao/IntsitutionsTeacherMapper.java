package com.jmr.IDao;

import com.jmr.model.IntsitutionsTeacher;
import com.jmr.model.IntsitutionsTeacherKey;

public interface IntsitutionsTeacherMapper {
    int deleteByPrimaryKey(IntsitutionsTeacherKey key);

    int insert(IntsitutionsTeacher record);

    int insertSelective(IntsitutionsTeacher record);

    IntsitutionsTeacher selectByPrimaryKey(IntsitutionsTeacherKey key);

    int updateByPrimaryKeySelective(IntsitutionsTeacher record);

    int updateByPrimaryKey(IntsitutionsTeacher record);
}