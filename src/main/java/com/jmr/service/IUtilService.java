package com.jmr.service;

public interface IUtilService {

	String getMd5(String plainText);
	int checkAccount(String username,String password);
	int getAccountInstitutionsId(String username,String password);
}
