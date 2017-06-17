package com.jmr.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmr.IDao.AttendanceMapper;
import com.jmr.model.Attendance;
import com.jmr.service.IAttendanceService;

@Service
public class AttendanceService implements IAttendanceService {
	@Autowired
    AttendanceMapper attendanceMapper;
//	
//    public List<Attendance> list(){
//        return t.selectAll();
//    };
//    
//    public void insertOne(Attendance attendance){
//    	t.insertSelective(attendance);
//    }
	public Map<String,Object> InsertAttendance(Attendance attendance){
		Map<String,Object> ansMap = new HashMap<String,Object>();
		attendance.setDatatime(new Date());
		attendance.setIsDelete(0);
		attendance.setCreateBy("test"); //TODO:cookie
		attendance.setCreateAt(new Date());
		if(attendanceMapper.insertSelective(attendance) == 0){
			System.out.println(attendanceMapper.insertSelective(attendance));
			ansMap.put("error","写入失败");
			return ansMap;
		}
		ansMap.put("success",true);
		return ansMap;
	}
}
