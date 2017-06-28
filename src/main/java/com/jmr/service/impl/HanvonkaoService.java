package com.jmr.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmr.IDao.StudentMapper;
import com.jmr.IDao.HanvonkaoMapper;
import com.jmr.model.Hanvonkao;
import com.jmr.service.IHanvonkaoService;


@Service
public class HanvonkaoService implements IHanvonkaoService {
	
	@Autowired
    HanvonkaoMapper t;
	@Override
	public List<Hanvonkao> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hanvonkao getOne(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOne(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOne(int id, String institut_id, String class_id, String student_id, String name, String time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertOne(int id,String institut_id, String class_id, String student_id, String name, String time) {
		Hanvonkao tmp=new Hanvonkao();
		tmp.setId(null);
		tmp.setInstitutId(institut_id);
		tmp.setClassId(class_id);
		tmp.setStudentId(student_id);
		tmp.setName(name);
		System.out.println(time);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try {   
            ts = Timestamp.valueOf(time);   
            tmp.setTime(ts);    
           } catch (Exception e) {   
            e.printStackTrace();   
          }  
		//System.out.println(tmp.getInstitutId());
        t.insertb(tmp);
	}

}
