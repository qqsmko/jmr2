package com.jmr.IDao;

import com.jmr.model.Ip_device;

public interface Ip_deviceMapper {
    int deleteByPrimaryKey(Integer devHao);

    int insert(Ip_device record);

    int insertSelective(Ip_device record);

    Ip_device selectByPrimaryKey(Integer devHao);

    int updateByPrimaryKeySelective(Ip_device record);

    int updateByPrimaryKey(Ip_device record);
}