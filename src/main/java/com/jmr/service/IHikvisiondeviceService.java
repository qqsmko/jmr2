package com.jmr.service;

import java.util.List;

import com.jmr.model.Hikvisiondev;

public interface IHikvisiondeviceService {
	List<Hikvisiondev> list();
	Hikvisiondev getOne(String sn);
	void deleteOne(String sn);
	void updateOne(String dev_hao,String iinstut_hao,String class_hao,String ip_adr,int  s_port,String sub_smask,
			String gate_ip,int http_port,String user_name,String user_pwd,String  dev_scipt,int stat_v,String save_adr);
	void insertOne(String dev_hao,String iinstut_hao,String class_hao,String ip_adr,int  s_port,String sub_smask,
			String gate_ip,int http_port,String user_name,String user_pwd,String  dev_scipt,int stat_v,String save_adr);
	
}
