package com.jmr.service;

import java.util.List;
import java.util.Map;

import com.jmr.model.Class;
import com.jmr.model.Course;

public interface IClassService {

	/*get*/
	Map<String,Object> getCourseData(int draw,int start,int length,String search);
	Map<String,Object> getClassSeriesData(int draw,int start,int length);
	Map<String,Object> getClassesData(int draw,int start,int length);
	Class getClassesShow(int id);
	Map<String,Object> getClassesDataTest(int draw,int start,int length,String search);
	Map<String,Object> getClassesDataWithState(int draw,int start,int length,String search,int state);
	Map<String,Object> getClassesDataWithId(int draw,int start,int length,int id);
	List<Map<String,Object>> getClassesDataWithIdNoPage(int id);
	Map<String,Object> getClassSeriesVerifyData(int draw,int start,int length);
	Map<String,Object> getClassSeriesCompletionData(int draw,int start,int length);

	/*insert*/
	Map<String,Object> insertCourse(Course course);
	Map<String,Object> insertClass(Class classes);
	
	/*delete*/
	Map<String,Object> deleteCourse(int id);
	Map<String,Object> deleteClass(int id);
	
	/*update*/
	Course getCourseById(int id);
	Map<String,Object> updateCourse(Course course);
	Class getClassById(int id);
	Map<String,Object> updateClass(Class classes);
	
	/*other*/
	Map<String,Object> submitApplyClass(int id);
	Map<String,Object> checkApplyClass(int id);
	Map<String,Object> rejectApplyClass(int id);
	
}