package com.jmr.service;

import java.util.List;

import com.jmr.model.Hanvondevice;


public interface IHanvondeviceService {
	List<Hanvondevice> list();
	Hanvondevice getOne(String sn);
	void deleteOne(String sn);
	void updateOne(String institut_hao,String sn,String ip,String subnetmask,String gateip,String class_id);
	void insertOne(String institut_hao,String sn,String ip,String subnetmask,String gateip,String class_id);
}
