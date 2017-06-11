package com.jmr.service.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmr.IDao.InstitutionsApplyMapper;
import com.jmr.IDao.InstitutionsFiledMapper;
import com.jmr.IDao.InstitutionsMapper;
import com.jmr.IDao.InstitutionsPrepareMapper;
import com.jmr.IDao.InstitutionsVerifyMapper;
import com.jmr.model.Institutions;
import com.jmr.model.InstitutionsPrepare;
import com.jmr.model.InstitutionsVerify;
import com.jmr.model.InstitutionsVerifyKey;
import com.jmr.service.IInstitutionsService;

@Service
public class InstitutionsService implements IInstitutionsService {
	@Autowired
    InstitutionsMapper institutionsMapper;
	@Autowired
    InstitutionsApplyMapper institutionsApplyMapper;
	@Autowired
	InstitutionsFiledMapper institutionsFiledMapper;
	@Autowired
	InstitutionsPrepareMapper institutionsPrepareMapper;
	@Autowired
	InstitutionsVerifyMapper institutionsVerifyMapper;
	
	
	public void newInstitutionsApply(Map<String,Object> institution){
		System.out.println("通过Map.keySet遍历key和value：");
		  for (String key : institution.keySet()) {
		   System.out.println("key= "+ key + " and value= " + institution.get(key));
		  }
		
		if(institution.containsKey("applyemail")
		&& institution.containsKey("responsible")
		&& institution.containsKey("institutionsname")
		&& institution.containsKey("address")
		&& institution.containsKey("regionid")
		&& institution.containsKey("employeecount")
		){
			System.out.println("good");
		}else{
			System.out.println("bad");
		}
	}
	
	public Map<String,Object> getApplyData(int draw,int start,int length){
		int totalNum = institutionsVerifyMapper.selectCount();
		List<InstitutionsVerify> dataVerify = institutionsVerifyMapper.selectByPage(start, length);
		List<InstitutionsPrepare> dataPrepare = new ArrayList<InstitutionsPrepare>();
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		for(int i=0;i<dataVerify.size();i++){
			int tempId = dataVerify.get(i).getInstitutionsId();
			InstitutionsPrepare info = institutionsPrepareMapper.selectByPrimaryKey(tempId);
			dataPrepare.add(info);
			Map<String, Object> map = transBean2Map(info); 
			Map<String, Object> map2 = transBean2Map(dataVerify.get(i));
			map.putAll(map2);
			data.add(map);
		}
		Map<String,Object> ansMap = new HashMap<String,Object>();
    	ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",data);
    	return ansMap;
	}
	
	public Map<String,Object> getInstitutionsData(int draw,int start,int length){
		int totalNum = institutionsMapper.selectCount();
		List<Institutions> data = institutionsMapper.selectByPage(start, length);
		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).getInstitutionsName());
		}
		Map<String,Object> ansMap = new HashMap<String,Object>();
    	ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",data);
    	return ansMap;
	}
	
	public Map<String,Object> InstitutionConfirm(int id){
		InstitutionsVerifyKey tempKey = new InstitutionsVerifyKey();
		tempKey.setInstitutionsId(id);
		InstitutionsVerify temp = institutionsVerifyMapper.selectByPrimaryKey(tempKey);
		Map<String,Object> ansMap = new HashMap<String,Object>();
		if(temp == null){
			ansMap.put("error","查无此数据");
			return ansMap;
		}
		temp.setApplyState(1);
		Date now = new Date();
		temp.setApprovalDate(now);
		if(institutionsVerifyMapper.updateByPrimaryKeySelective(temp) == 0){
			ansMap.put("error","写入出现异常");
			return ansMap;
		}
		ansMap.put("success",true);
		return ansMap;
	}
	
	public Map<String,Object> InstitutionReject(int id){
		InstitutionsVerifyKey tempKey = new InstitutionsVerifyKey();
		tempKey.setInstitutionsId(id);
		InstitutionsVerify temp = institutionsVerifyMapper.selectByPrimaryKey(tempKey);
		Map<String,Object> ansMap = new HashMap<String,Object>();
		if(temp == null){
			ansMap.put("error","查无此数据");
			return ansMap;
		}
		System.out.println(temp.getApplyState());
		return ansMap;
	}
//    public List<Institutions> list(){
//        return t.selectAll();
//    };
//    
//    public Map<String,Object> getData(int draw,int start,int length){
//    	int totalNum = t.selectCount();
//    	List<Institutions> dataSet = t.selectByPage(start,length);
//    	Map<String,Object> ansMap = new HashMap<String,Object>();
//    	ansMap.put("draw",draw);
//    	ansMap.put("recordsTotal",totalNum);
//		ansMap.put("recordsFiltered",totalNum);
//		ansMap.put("data",dataSet);
//    	return ansMap;
//    }
//    
//    public void deleteOne(int num){
//    	//t.deleteByPrimaryKey(num);
//    	t.softDelete(num);
//    }
//    
//    public void updateOne(Institutions institutions){
//    	t.updateByPrimaryKeySelective(institutions);
//    }
//    
//    public void insertOne(Institutions institutions){
//    	institutions.setState(2);
//    	t.insertSelective(institutions);
//    }
//    
//    public void setOnesState(int id,int num){
//    	Institutions temp = t.selectByPrimaryKey(id);
//    	temp.setState(num);
//    	t.updateByPrimaryKeySelective(temp);
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
