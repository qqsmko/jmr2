package com.jmr.service;

import java.util.List;
import java.util.Map;

import com.jmr.model.Attendance;
import com.jmr.model.Teacher;

public interface IAttendanceService {

//	List<Attendance> list();
//	void insertOne(Attendance attendance);
	Map<String,Object> InsertAttendance(Attendance attendance);
}
