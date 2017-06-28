package com.jmr.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jmr.model.Course;
import com.jmr.model.Teacher;

public interface ITeacherService {

	/*get*/
	Map<String,Object> getTeacherData(int draw,int start,int length,String search);
	
	/*insert*/
	Map<String,Object> InsertTeacher(Map<String,Object> json);

	/*delete*/
	Map<String,Object> deleteTeacher(int id);
	
	/*update*/
	Teacher getTeacherById(int id);
	Map<String,Object> updateTeacher(Teacher teacher);
	
}
