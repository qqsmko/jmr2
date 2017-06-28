package com.jmr.service;

import java.util.List;
import java.util.Map;

import com.jmr.model.Institutions;

public interface IInstitutionsService {

	void newInstitutionsApply(Map<String,Object> institution);
	Map<String,Object> getApplyData(int draw,int start,int length);
	Map<String,Object> getInstitutionsData(int draw,int start,int length);
	Map<String,Object> InstitutionReject(int id);
	Map<String,Object> InstitutionConfirm(int id);
	
	List<Institutions> list();
//	Map<String,Object> getData(int draw,int start,int length);
//	void deleteOne(int num);
//	void updateOne(Institutions institutions);
//	void insertOne(Institutions institutions);
//	void setOnesState(int id,int num);
}
