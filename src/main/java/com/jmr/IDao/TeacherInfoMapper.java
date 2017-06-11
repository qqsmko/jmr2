package com.jmr.IDao;

import com.jmr.model.TeacherInfo;
import com.jmr.model.TeacherInfoKey;

public interface TeacherInfoMapper {
    int deleteByPrimaryKey(TeacherInfoKey key);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    TeacherInfo selectByPrimaryKey(TeacherInfoKey key);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);
}