package com.jmr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmr.IDao.HanvondeviceMapper;
import com.jmr.model.Hanvondevice;
import com.jmr.service.IHanvondeviceService;
@Service
public class HanvondeviceService implements IHanvondeviceService {

	@Autowired
	HanvondeviceMapper hw;
	public List<Hanvondevice> list() {
		// TODO Auto-generated method stub
		return hw.selectAll();
	}

	@Override
	public Hanvondevice getOne(String sn) {
		//Hanvondevice tt=hw.selectByPrimaryKey(sn);
		//System.out.println(tt.getGateip());
		return hw.selectByPrimaryKey(sn);
	}

	@Override
	public void deleteOne(String sn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOne(String institut_hao, String sn, String ip, String subnetmask, String gateip,
			String class_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertOne(String institut_hao, String sn, String ip, String subnetmask, String gateip,
			String class_id) {
		Hanvondevice tmp=new Hanvondevice();
		tmp.setClassId(class_id);
		tmp.setGateip(gateip);
		tmp.setInstitutHao(institut_hao);
		tmp.setIp(ip);
		tmp.setSn(sn);
		tmp.setSubnetmask(subnetmask);
		hw.insert(tmp);
	}

}
