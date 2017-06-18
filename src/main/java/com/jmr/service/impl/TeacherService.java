package com.jmr.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmr.IDao.IdcardMapper;
import com.jmr.IDao.IntsitutionsTeacherMapper;
import com.jmr.IDao.TeacherInfoMapper;
import com.jmr.IDao.TeacherMapper;
import com.jmr.model.Course;
import com.jmr.model.Idcard;
import com.jmr.model.IntsitutionsTeacher;
import com.jmr.model.Teacher;
import com.jmr.model.TeacherInfo;
import com.jmr.model.TeacherInfoKey;
import com.jmr.service.ITeacherService;

@Service
public class TeacherService implements ITeacherService {
	@Autowired
    TeacherInfoMapper teacherInfoMapper;
	@Autowired
	TeacherMapper teacherMapper;
	@Autowired
	IdcardMapper idcardMapper;
	@Autowired
	IntsitutionsTeacherMapper instituitonsTeacherMapper;
	
	/*--------------------------------------------------------*/
	//                         Get
	/*--------------------------------------------------------*/
	
	public Map<String,Object> getTeacherData(int draw,int start,int length,String search){
		if(search==""){
			int totalNum = teacherInfoMapper.selectCount();
	    	List<Map<String,Object>> dataSet = teacherInfoMapper.selectByPageSQL(start,length);
	    	Map<String,Object> ansMap = new HashMap<String,Object>();
	    	ansMap.put("draw",draw);
	    	ansMap.put("recordsTotal",totalNum);
			ansMap.put("recordsFiltered",totalNum);
			ansMap.put("data",dataSet);
	    	return ansMap;
		}else{
			int totalNum = teacherInfoMapper.selectCount();
			int totalFiltered = teacherInfoMapper.selectFilteredCount("%"+search+"%");
			List<Map<String,Object>> data = teacherInfoMapper.selectByPageWithName(start, length, "%"+search+"%");
			Map<String,Object> ansMap = new HashMap<String,Object>();
			ansMap.put("draw",draw);
	    	ansMap.put("recordsTotal",totalNum);
			ansMap.put("recordsFiltered",totalFiltered);
			ansMap.put("data",data);
	    	return ansMap;
		}
    }
	
	
	
	
	/*--------------------------------------------------------*/
	//                         Insert
	/*--------------------------------------------------------*/
	
	public Map<String,Object> InsertTeacher(Map<String,Object> json){
		Map<String,Object> ansMap = new HashMap<String,Object>();
		if(json.containsKey("cardId")
			&& json.containsKey("cardName")
			&& json.containsKey("gender")
			&& json.containsKey("nation")
			&& json.containsKey("birthday")
			&& json.containsKey("address")
			&& json.containsKey("telephone")
			&& json.containsKey("email")
			&& json.containsKey("education")
			){
			
			Idcard idcard = new Idcard();
			idcard.setCardId(json.get("cardId").toString());
			idcard.setCardName(json.get("cardName").toString());
			idcard.setGender(Integer.parseInt(json.get("gender").toString()));
			idcard.setNation(json.get("nation").toString());
			Date date = null;
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    	date = sdf.parse(json.get("birthday").toString());
		    }catch(ParseException e){
		    	System.out.println(e.getMessage());
		    }
			idcard.setBirthday(date);
			idcard.setNation(json.get("nation").toString());
			idcard.setAddress(json.get("address").toString());
			idcard.setIsDelete(0);
			idcard.setCreateBy("test"); //TODO:cookie
			idcard.setCreateAt(new Date());
			if(idcardMapper.insertSelective(idcard) == 0){
				ansMap.put("error","插入失败");
				return ansMap;
			}
			
			Teacher teacher = new Teacher();
			teacher.setEmail(json.get("email").toString());
			teacher.setTelephone(json.get("telephone").toString());
			teacher.setEducation(Integer.parseInt(json.get("education").toString()));
			teacher.setIsDelete(0);
			teacher.setState(0);
			teacher.setCreateBy("test"); //TODO:cookie
			teacher.setCreateAt(new Date());
			if(teacherMapper.insertSelective(teacher) == 0){
				ansMap.put("error","插入失败");
				return ansMap;
			}
			int teacherId = teacher.getTeacherId();
			System.out.println(teacherId);
			
			IntsitutionsTeacher temp = new IntsitutionsTeacher();
			temp.setInstitutionsId(999999999);
			temp.setTeacherId(teacherId);
			temp.setIsDelete(0);
			temp.setCreateBy("test"); //TODO:cookie
			temp.setCreateAt(new Date());
			if(instituitonsTeacherMapper.insertSelective(temp) == 0){
				ansMap.put("error","写入关联表失败");
				return ansMap;
			}
			
			System.out.println(teacherId);
			TeacherInfo temp2 = new TeacherInfo();
			temp2.setCardId(json.get("cardId").toString());
			temp2.setTeacherId(teacherId);
			temp2.setIsDelete(0);
			temp2.setCreateBy("test"); //TODO:cookie
			temp2.setCreateAt(new Date());
			if(teacherInfoMapper.insertSelective(temp2) == 0){
				ansMap.put("error","写入关联表失败");
				return ansMap;
			}
			
			System.out.println(teacherId);
			ansMap.put("success",true);
			return ansMap;
		}
		ansMap.put("error","参数不符");
		return ansMap;
	}
	
	
	
	
	/*--------------------------------------------------------*/
	//                         Delete
	/*--------------------------------------------------------*/
	
	public Map<String,Object> deleteTeacher(int id){
		TeacherInfoKey key = new TeacherInfoKey();
		key.setTeacherId(id);
		TeacherInfo temp = teacherInfoMapper.selectByPrimaryKey(key);
		Map<String,Object> ansMap = new HashMap<String,Object>();
		if(temp == null){
			ansMap.put("error","查无此数据");
			return ansMap;
		}
		temp.setIsDelete(1);
		String idcard = temp.getCardId();
		Teacher temp2 = teacherMapper.selectByPrimaryKey(id);
		temp2.setIsDelete(1);
		if(teacherMapper.updateByPrimaryKeySelective(temp2) == 0){
			ansMap.put("error","写入出现异常");
			return ansMap;
		}
		Idcard temp3 = idcardMapper.selectByPrimaryKey(idcard);
		temp3.setIsDelete(1);
		if(idcardMapper.updateByPrimaryKeySelective(temp3) == 0){
			ansMap.put("error","写入出现异常");
			return ansMap;
		}
		ansMap.put("success",true);
		return ansMap;
	}
	
	
	
	/*--------------------------------------------------------*/
	//                         Update
	/*--------------------------------------------------------*/
	
	public Teacher getTeacherById(int id){
		Teacher temp = teacherMapper.selectByPrimaryKey(id);
		return temp;
	}
	
	public Map<String,Object> updateTeacher(Teacher teacher){
		Map<String,Object> ansMap = new HashMap<String,Object>();
		if(teacherMapper.updateByPrimaryKeySelective(teacher) == 0){
			ansMap.put("error","写入失败");
			return ansMap;
		}
		ansMap.put("success",true);
		return ansMap;
	}
}
