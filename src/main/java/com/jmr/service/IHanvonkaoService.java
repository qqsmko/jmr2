package com.jmr.service;

import java.util.List;


import com.jmr.model.Hanvonkao;

public interface IHanvonkaoService {
	List<Hanvonkao> list();
	Hanvonkao getOne(int num);
	void deleteOne(int num);
	void updateOne(int id,String institut_id,String class_id,String student_id,String name,String time);
	void insertOne(int id,String institut_id,String class_id,String student_id,String name,String time);
}
