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
import com.jmr.IDao.StudentInfoMapper;
import com.jmr.IDao.StudentMapper;
import com.jmr.model.Idcard;
import com.jmr.model.Student;
import com.jmr.model.StudentInfo;
import com.jmr.model.StudentInfoKey;
import com.jmr.service.IStudentService;

@Service
public class StudentService implements IStudentService{

	@Autowired
    StudentInfoMapper studentInfoMapper;
	@Autowired
	IdcardMapper idcardMapper;
	@Autowired
	StudentMapper studentMapper;
	
	/*--------------------------------------------------------*/
	//                         Get
	/*--------------------------------------------------------*/
	
	public Map<String,Object> getIdCardData(int draw,int start,int length){
		int totalNum = idcardMapper.selectCount();
		List<Idcard> data = idcardMapper.selectByPage(start, length);
		Map<String,Object> ansMap = new HashMap<String,Object>();
    	ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",data);
    	return ansMap;
	}

	public Map<String,Object> getStudentData(int draw,int start,int length,String search){
		if(search==""){
			int totalNum = studentInfoMapper.selectCount();
			List<Map<String,Object>> data = studentInfoMapper.selectByPageSQL(start, length);
			Map<String,Object> ansMap = new HashMap<String,Object>();
	    	ansMap.put("draw",draw);
	    	ansMap.put("recordsTotal",totalNum);
			ansMap.put("recordsFiltered",totalNum);
			ansMap.put("data",data);
	    	return ansMap;
		}else{
			int totalNum = studentInfoMapper.selectCount();
			int totalFiltered = studentInfoMapper.selectFilteredCount(search);
			List<Map<String,Object>> data = studentInfoMapper.selectByPageWithName(start, length, "%"+search+"%");
			Map<String,Object> ansMap = new HashMap<String,Object>();
			ansMap.put("draw",draw);
	    	ansMap.put("recordsTotal",totalNum);
			ansMap.put("recordsFiltered",totalFiltered);
			ansMap.put("data",data);
	    	return ansMap;
		}
	}
	
	public StudentInfo getStudentById(int id){
		StudentInfoKey key = new StudentInfoKey();
		key.setStudentId(id);
		return studentInfoMapper.selectByPrimaryKey(key);
	}
	
	/*--------------------------------------------------------*/
	//                         Insert
	/*--------------------------------------------------------*/
	
	public Map<String,Object> InsertStudent(Map<String,Object> json){
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
			&& json.containsKey("insuredstate")
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
			
			Student student = new Student();
			student.setEmail(json.get("email").toString());
			student.setTelephone(json.get("telephone").toString());
			student.setEducation(Integer.parseInt(json.get("education").toString()));
			student.setInsuredState(Integer.parseInt(json.get("insuredstate").toString()));
			student.setState(1);
			student.setIsDelete(0);
			student.setCreateBy("test"); //TODO:cookie
			student.setCreateAt(new Date());
			if(studentMapper.insertSelective(student) == 0){
				System.out.println(studentMapper.insertSelective(student));
				ansMap.put("error","鍐欏叆澶辫触");
				return ansMap;
			}
			
			int studentId = student.getStudentId();
			
			StudentInfo temp = new StudentInfo();
			temp.setCardId(json.get("cardId").toString());
			temp.setStudentId(studentId);
			temp.setIsDelete(0);
			temp.setCreateBy("test"); //TODO:cookie
			temp.setCreateAt(new Date());
			if(studentInfoMapper.insertSelective(temp) == 0){
				ansMap.put("error","写入关联表失败");
				return ansMap;
			}
			
			ansMap.put("success",true);
			return ansMap;
		}
		ansMap.put("error","参数不符");
		return ansMap;
	}
	
	
//    public Student getOne(int num){
//    	return t.selectByPrimaryKey(num);
//    }
//    
//    public void setOnesState(int num){
//    	Student temp;
//    	temp = t.selectByPrimaryKey(num);
//    	int statex = temp.getState();
//    	if(statex==1) statex=2;
//    	else statex = 1;
//    	temp.setState(statex);
//    	t.updateByPrimaryKey(temp);
//    }
//    
//    public void deleteOne(int num){
//    	t.deleteByPrimaryKey(num);
//    }
//    
//    public void updateOne(String studentid,String name,String gender,String birthday,String telephone,String email,String address,String nation,String education,String insuredstate){
//    	
//    	Student temp = new Student();
//    	Integer id = Integer.parseInt(studentid);
//    	temp.setStudentid(id);
//    	if(name==""){
//    		temp.setName(null);
//    	}else{
//    		temp.setName(name);
//    	}
//    	if(gender==""){
//    		temp.setGender(null);
//    	}else{
//    		short genderb = Short.parseShort(gender);
//    	temp.setGender(genderb);
//    	}
//    	try{
//	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	    		Date birthdayb = sdf.parse(birthday);
//	    		temp.setBirthday(birthdayb);
//	    	}catch(ParseException e){
//	    		temp.setBirthday(null);
//	    		System.out.println(e.getMessage());
//	    	}
//    	if(telephone==""){
//    		temp.setTelephone(null);
//    	}else{
//    		temp.setTelephone(telephone);
//    	}
//    	if(email==""){
//    		temp.setEmail(null);
//    	}else{
//    		temp.setEmail(email);
//    	}
//    	if(address==""){
//    		temp.setAddress(null);
//    	}else{
//    		temp.setAddress(address);
//    	}
//    	if(nation==""){
//    		temp.setNation(null);
//    	}else{
//    		temp.setNation(nation);
//    	}
//    	if(education==""){
//    		temp.setEducation(null);
//    	}else{
//    		Integer educationb = Integer.parseInt(education);
//    		temp.setEducation(educationb);
//    	}
//    	if(insuredstate==""){
//    		temp.setInsuredstate(null);
//    	}else{
//    		Integer insuredstateb = Integer.parseInt(insuredstate);
//    		temp.setInsuredstate(insuredstateb);
//    	}
//    	temp.setState(null);
//    	t.updateByPrimaryKeySelective(temp);
//    }
//    
//    public void insertOne(String name,String gender,String birthday,String telephone,String email,String address,String nation,String education,String insuredstate){
//    	
//    	Student temp = new Student();
//    	
//    	temp.setStudentid(null);
//    	temp.setName(name);
//    	short genderb = Short.parseShort(gender);
//    	temp.setGender(genderb);
//    	try{
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    		Date birthdayb = sdf.parse(birthday);
//    		temp.setBirthday(birthdayb);
//    	}catch(ParseException e){
//    		temp.setBirthday(null);
//    		System.out.println(e.getMessage());
//    	}
//    	temp.setTelephone(telephone);
//    	temp.setEmail(email);
//    	temp.setAddress(address);
//    	temp.setNation(nation);
//    	Integer educationb = Integer.parseInt(education);
//    	temp.setEducation(educationb);
//    	Integer insuredstateb = Integer.parseInt(insuredstate);
//    	temp.setInsuredstate(insuredstateb);
//    	temp.setState(1);
//    	t.insertSelective(temp);
//    }
}
