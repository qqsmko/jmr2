package com.jmr.service;

import java.util.List;
import java.util.Map;

import com.jmr.model.Class;

public interface IClassService {

	Map<String,Object> getCourseData(int draw,int start,int length);
	Map<String,Object> getClassSeriesData(int draw,int start,int length);
	Map<String,Object> getClassesData(int draw,int start,int length);
	Map<String,Object> getClassesDataTest(int draw,int start,int length);
	Map<String,Object> getClassSeriesVerifyData(int draw,int start,int length);
	Map<String,Object> getClassSeriesCompletionData(int draw,int start,int length);

//	List<Class> list();
//	List<Class> listApplication();
//	List<Class> listFinishied();
//	void deleteOne(int num);
//	void updateOne(String classid,String classname,String applynumber,String startdate,String enddate,String remark,String applyperson);
//	void insertOne(String classname,String applynumber,String startdate,String enddate,String remark,String applyperson);
//	void updateOnesState(int id, int num);
}