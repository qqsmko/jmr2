package com.jmr.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmr.IDao.TeacherInfoMapper;
import com.jmr.IDao.TeacherMapper;
import com.jmr.model.Teacher;
import com.jmr.service.ITeacherService;

@Service
public class TeacherService implements ITeacherService {
	@Autowired
    TeacherInfoMapper teacherInfoMapper;
	@Autowired
	TeacherMapper teacherMapper;
//	
//	public Teacher getOne(int teacherid){
//		return t.selectByPrimaryKey(teacherid);
//	}
//	
//    public List<Teacher> list(){
//        return t.selectAll();
//    };
//    
//    public void deleteOne(int num){
//    	t.softDelete(num);
//    }
//    
//    public void updateOne(String teacherid,String name){
//    	Teacher temp = new Teacher();
//    	Integer id = Integer.parseInt(teacherid);
//    	temp.setTeacherid(id);
//    	if(name==""){
//    		temp.setName(null);
//    	}else{
//    		temp.setName(name);
//    	}
//    	t.updateByPrimaryKeySelective(temp);
//    }
//    
//	public void insertOne(String name){
//		Teacher temp = new Teacher();
//    	
//    	temp.setTeacherid(null);
//    	temp.setName(name);
//    	t.insertSelective(temp);
//	}
//	
	public Map<String,Object> getData(int draw,int start,int length){
    	int totalNum = teacherInfoMapper.selectCount();
    	List<Map<String,Object>> dataSet = teacherInfoMapper.selectByPageSQL(start,length);
    	Map<String,Object> ansMap = new HashMap<String,Object>();
    	ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",dataSet);
    	return ansMap;
    }
	public Map<String,Object> InsertTeacher(Teacher teacher){
		Map<String,Object> ansMap = new HashMap<String,Object>();
		teacher.setIsDelete(0);
		teacher.setCreateBy("test"); //TODO:cookie
		teacher.setCreateAt(new Date());
		if(teacherMapper.insertSelective(teacher) == 0){
			System.out.println(teacherMapper.insertSelective(teacher));
			ansMap.put("error","写入失败");
			return ansMap;
		}
		ansMap.put("success2",true);
		return ansMap;
	}
}
