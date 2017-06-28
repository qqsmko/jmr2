package com.jmr.IDao;

import java.util.List;

import com.jmr.model.Hanvondevice;
import com.jmr.model.Student;

public interface HanvondeviceMapper {
    int deleteByPrimaryKey(String sn);

    int insert(Hanvondevice record);

    int insertSelective(Hanvondevice record);

    Hanvondevice selectByPrimaryKey(String sn);

    int updateByPrimaryKeySelective(Hanvondevice record);

    int updateByPrimaryKey(Hanvondevice record);
    
    List<Hanvondevice> selectAll();
}