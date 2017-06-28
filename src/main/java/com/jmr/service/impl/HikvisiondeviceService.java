package com.jmr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmr.IDao.HikvisiondevMapper;
import com.jmr.model.Hanvondevice;
import com.jmr.model.Hikvisiondev;
import com.jmr.service.IHikvisiondeviceService;

@Service
public class HikvisiondeviceService implements IHikvisiondeviceService {
    @Autowired
    HikvisiondevMapper hkvs;
	@Override
	public List<Hikvisiondev> list() {
		// TODO Auto-generated method stub
		return hkvs.selectAll();
	}

	@Override
	public Hikvisiondev getOne(String sn) {
		// TODO Auto-generated method stub
		return hkvs.selectByPrimaryKey(sn);
	}

	@Override
	public void deleteOne(String sn) {
		hkvs.deleteByPrimaryKey(sn);
	}



	@Override
	public void updateOne(String dev_hao, String iinstut_hao, String class_hao, String ip_adr, int s_port,
			String sub_smask, String gate_ip, int http_port, String user_name, String user_pwd, String dev_scipt,
			int stat_v, String save_adr) {
		Hikvisiondev record=new Hikvisiondev();
		record.setClassHao(class_hao);
		record.setDevHao(dev_hao);
		record.setDevScipt(dev_scipt);
		record.setGateIp(gate_ip);
		record.setHttpPort(http_port);
		record.setIinstutHao(iinstut_hao);
		record.setIpAdr(ip_adr);
		record.setSaveAdr(save_adr);
		record.setsPort(s_port);
		record.setStatV(stat_v);
		record.setSubSmask(sub_smask);
		record.setUserName(user_name);
		record.setUserPwd(user_pwd);
		hkvs.updateByPrimaryKey(record);
		
	}

	@Override
	public void insertOne(String dev_hao, String iinstut_hao, String class_hao, String ip_adr, int s_port,
			String sub_smask, String gate_ip, int http_port, String user_name, String user_pwd, String dev_scipt,
			int stat_v, String save_adr) {
		Hikvisiondev tmp=new Hikvisiondev();
		tmp.setClassHao(class_hao);
		tmp.setDevHao(dev_hao);
		tmp.setDevScipt(dev_scipt);
		tmp.setGateIp(gate_ip);
		tmp.setHttpPort(http_port);
		tmp.setIinstutHao(iinstut_hao);
		tmp.setIpAdr(ip_adr);
		tmp.setSaveAdr(save_adr);
		tmp.setsPort(s_port);
		tmp.setStatV(stat_v);
		tmp.setSubSmask(sub_smask);
		tmp.setUserName(user_name);
		tmp.setUserPwd(user_pwd);
		hkvs.insert(tmp);
		
	}

}
