package com.jmr.service.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmr.IDao.ClassClassSeriesMapper;
import com.jmr.IDao.ClassMapper;
import com.jmr.IDao.ClassSeriesCompletionMapper;
import com.jmr.IDao.ClassSeriesCourseMapper;
import com.jmr.IDao.ClassSeriesMapper;
import com.jmr.IDao.ClassSeriesStudentMapper;
import com.jmr.IDao.ClassSeriesTeacherMapper;
import com.jmr.IDao.ClassSeriesVerifyMapper;
import com.jmr.IDao.ClassSeriesVerifyedMapper;
import com.jmr.IDao.CourseInstitutionsMapper;
import com.jmr.IDao.CourseMapper;
import com.jmr.model.Class;
import com.jmr.model.ClassClassSeries;
import com.jmr.model.ClassClassSeriesKey;
import com.jmr.model.ClassSeries;
import com.jmr.model.ClassSeriesCompletion;
import com.jmr.model.ClassSeriesVerify;
import com.jmr.model.Course;
import com.jmr.service.IClassService;

@Service
public class ClassService implements IClassService {
	@Autowired
    ClassMapper classMapper;
	@Autowired
    ClassClassSeriesMapper classClassSeriesMapper;
	@Autowired
	ClassSeriesCompletionMapper classSeriesCompletionMapper;
	@Autowired
	ClassSeriesMapper classSeriesMapper;
	@Autowired
	ClassSeriesCourseMapper classSeriesCoursenMapper;
	@Autowired
	ClassSeriesStudentMapper classSeriesStudentMapper;
	@Autowired
	ClassSeriesTeacherMapper classSeriesTeacherMapper;
	@Autowired
	ClassSeriesVerifyMapper classSeriesVerifyMapper;
	@Autowired
	ClassSeriesVerifyedMapper classSeriesVerifyedMapper;
	@Autowired
	CourseInstitutionsMapper courseInstitutionsMapper;
	@Autowired
	CourseMapper courseMapper;
	
	public Map<String,Object> getCourseData(int draw,int start,int length){
		int totalNum = courseMapper.selectCount();
		List<Course> data = courseMapper.selectByPage(start, length);
		Map<String,Object> ansMap = new HashMap<String,Object>();
    	ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",data);
    	return ansMap;
	}
	
	public Map<String,Object> getClassSeriesData(int draw,int start,int length){
		int totalNum = classSeriesMapper.selectCount();
		List<ClassSeries> data = classSeriesMapper.selectByPage(start, length);
		Map<String,Object> ansMap = new HashMap<String,Object>();
    	ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",data);
    	return ansMap;
	}
	
	public Map<String,Object> getClassesData(int draw,int start,int length){
		int totalNum = classMapper.selectCount();
		List<Class> classData = classMapper.selectByPage(start, length);
		Map<String,Object> ansMap = new HashMap<String,Object>();
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		for(int i=0;i<classData.size();i++){
			int tempId = classData.get(i).getClassId();
			ClassClassSeriesKey tempKey = new ClassClassSeriesKey();
			tempKey.setClassId(tempId);
			ClassClassSeries tempInfo = classClassSeriesMapper.selectByPrimaryKey(tempKey);
			tempId = tempInfo.getClassSeriesId();
			ClassSeries tempName = classSeriesMapper.selectByPrimaryKey(tempId);
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("classSeriesName", tempName.getClassSeriesName());
			Map<String, Object> map2 = transBean2Map(classData.get(i));
			map.putAll(map2);
			data.add(map);
		}
    	ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",data);
    	return ansMap;
	}
	
	public Map<String,Object> getClassesDataTest(int draw,int start,int length){
		int totalNum = classMapper.selectCount();
		List<Map<String,Object>> data = classMapper.selectByPageSQL(start, length);
		Map<String,Object> ansMap = new HashMap<String,Object>();
		ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",data);
    	return ansMap;
	}
	
	public Map<String,Object> getClassSeriesVerifyData(int draw,int start,int length){
		int totalNum = classSeriesVerifyMapper.selectCount();
		List<ClassSeriesVerify> data = classSeriesVerifyMapper.selectByPage(start, length);
		Map<String,Object> ansMap = new HashMap<String,Object>();
    	ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",data);
    	return ansMap;
	}
	
	public Map<String,Object> getClassSeriesCompletionData(int draw,int start,int length){
		int totalNum = classSeriesCompletionMapper.selectCount();
		List<ClassSeriesCompletion> data = classSeriesCompletionMapper.selectByPage(start, length);
		Map<String,Object> ansMap = new HashMap<String,Object>();
    	ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",data);
    	return ansMap;
	}
	
//    public List<Class> list(){
//        return t.selectAll();
//    };
//    
//    public List<Class> listApplication(){
//        return t.selectApplication();
//    };
//    
//    public List<Class> listFinishied(){
//        return t.selectFinishied();
//    };
//    
//    public void deleteOne(int num){
//    	t.deleteByPrimaryKey(num);
//    }
//    
//    public void updateOne(String classid,String classname,String applynumber,String startdate,String enddate,String remark,String applyperson){
//    	
//    	Class temp = new Class();
//    	Integer id = Integer.parseInt(classid);
//    	temp.setClassid(id);
//    	if(classname==""){
//    		temp.setClassname(null);
//    	}else{
//    		temp.setClassname(classname);
//    	}
//    	if(applynumber==""){
//    		temp.setApplynumber(null);
//    	}else{
//    		Integer applynumberb = Integer.parseInt(applynumber);
//    		temp.setApplynumber(applynumberb);
//    	}
//    		try{
//	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	    		Date startdateb = sdf.parse(startdate);
//	    		temp.setStartdate(startdateb);
//	    	}catch(ParseException e){
//	    		temp.setStartdate(null);
//	    		System.out.println(e.getMessage());
//	    	}
//    		try{
//	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	    		Date enddateb = sdf.parse(enddate);
//	    		temp.setEnddate(enddateb);
//	    	}catch(ParseException e){
//	    		temp.setEnddate(null);
//	    		System.out.println(e.getMessage());
//	    	}
//    	if(remark==""){
//    		temp.setRemark(null);
//    	}else{
//    		temp.setRemark(remark);
//    	}
//    	if(applyperson==""){
//    		temp.setApplyperson(null);
//    	}else{
//    		temp.setApplyperson(applyperson);
//    	}
//    	t.updateByPrimaryKeySelective(temp);
//    }
//    
//    public void insertOne(String classname,String applynumber,String startdate,String enddate,String remark,String applyperson){
//    	
//    	Class temp = new Class();
//    	
//    	temp.setClassid(null);
//    	temp.setClassname(classname);
//    	Integer applynumberb = Integer.parseInt(applynumber);
//    	temp.setApplynumber(applynumberb);
//    	try{
//	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	    		Date startdateb = sdf.parse(startdate);
//	    		temp.setStartdate(startdateb);
//	    	}catch(ParseException e){
//	    		temp.setStartdate(null);
//	    		System.out.println(e.getMessage());
//	    	}
//    		try{
//	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	    		Date enddateb = sdf.parse(enddate);
//	    		temp.setEnddate(enddateb);
//	    	}catch(ParseException e){
//	    		temp.setEnddate(null);
//	    		System.out.println(e.getMessage());
//	    	}
//    		temp.setRemark(remark);
//    		temp.setApplyperson(applyperson);
//    	t.insertSelective(temp);
//    }
//    
//    public void updateOnesState(int id, int num){
//    	Class temp = new Class();
//    	temp.setClassid(id);
//    	temp.setApplystate(num);
//    	t.updateState(temp);
//    }
	
	public static Map<String, Object> transBean2Map(Object obj) {  
		  
        if(obj == null){  
            return null;  
        }          
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                // 过滤class属性  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
  
                    map.put(key, value);  
                }  
  
            }  
        } catch (Exception e) {  
            System.out.println("transBean2Map Error " + e);  
        }  
  
        return map;  
  
    }  
}
