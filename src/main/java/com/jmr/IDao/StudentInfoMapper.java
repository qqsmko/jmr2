package com.jmr.IDao;

import com.jmr.model.StudentInfo;
import com.jmr.model.StudentInfoKey;

public interface StudentInfoMapper {
    int deleteByPrimaryKey(StudentInfoKey key);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(StudentInfoKey key);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}