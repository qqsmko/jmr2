package com.jmr.IDao;

import java.util.List;

import com.jmr.model.Hanvondevice;
import com.jmr.model.Hikvisiondev;

public interface HikvisiondevMapper {
    int deleteByPrimaryKey(String devHao);

    int insert(Hikvisiondev record);

    int insertSelective(Hikvisiondev record);

    Hikvisiondev selectByPrimaryKey(String devHao);

    int updateByPrimaryKeySelective(Hikvisiondev record);

    int updateByPrimaryKey(Hikvisiondev record);
    
    List<Hikvisiondev> selectAll();
}