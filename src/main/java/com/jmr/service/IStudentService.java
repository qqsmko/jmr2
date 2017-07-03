package com.jmr.service;

import java.util.List;
import java.util.Map;

import com.jmr.model.Student;
import com.jmr.model.Teacher;

public interface IStudentService {

	/*get*/
	Map<String,Object> getIdCardData(int draw,int start,int length);
	Map<String,Object> getStudentData(int draw,int start,int length,String search);
	
	/*insert*/
	Map<String,Object> InsertStudent(Map<String,Object> json);

	
//	List<Student> list();
//	Student getOne(int num);
//	void setOnesState(int num);
//	void deleteOne(int num);
//	void updateOne(String studentid,String name,String gender,String birthday,String telephone,String email,String address,String nation,String education,String insuredstate);
//	void insertOne(String name,String gender,String birthday,String telephone,String email,String address,String nation,String education,String insuredstate);

}
