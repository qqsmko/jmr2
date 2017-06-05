package com.jmr.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmr.dao.InstitutionsMapper;
import com.jmr.model.Institutions;
import com.jmr.service.IInstitutionsService;

@Service
public class InstitutionsService implements IInstitutionsService {
	@Autowired
    InstitutionsMapper t;
	
    public List<Institutions> list(){
        return t.selectAll();
    };
    
    public Map<String,Object> getData(int draw,int start,int length){
    	int totalNum = t.selectCount();
    	List<Institutions> dataSet = t.selectByPage(start,length);
    	Map<String,Object> ansMap = new HashMap<String,Object>();
    	ansMap.put("draw",draw);
    	ansMap.put("recordsTotal",totalNum);
		ansMap.put("recordsFiltered",totalNum);
		ansMap.put("data",dataSet);
    	return ansMap;
    }
    
    public void deleteOne(int num){
    	//t.deleteByPrimaryKey(num);
    	t.softDelete(num);
    }
    
    public void updateOne(Institutions institutions){
    	t.updateByPrimaryKeySelective(institutions);
    }
    
    public void insertOne(Institutions institutions){
    	institutions.setState(2);
    	t.insertSelective(institutions);
    }
    
    public void setOnesState(int id,int num){
    	Institutions temp = t.selectByPrimaryKey(id);
    	temp.setState(num);
    	t.updateByPrimaryKeySelective(temp);
    }
}
