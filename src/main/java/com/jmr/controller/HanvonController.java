package com.jmr.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.jmr.model.Hanvondevice;
import com.jmr.model.Institutions;
import com.jmr.service.IHanvondeviceService;
import com.jmr.service.IHanvonkaoService;
import com.jmr.service.IInstitutionsService;



@Controller
@RequestMapping("")
public class HanvonController {
		@Autowired
		IHanvondeviceService hwdev;
		@Autowired
		IHanvonkaoService hks;
		@Autowired
		IInstitutionsService instut;
		
		@RequestMapping(value="hanvon_dev",method=RequestMethod.GET)
	    public ModelAndView listHanvon_dev(){
			
	        //hks.insertOne(111, "10104", "201706", "123456", "bmcgf", "2017-01-01 12:01:02");
	        ModelAndView mav = new ModelAndView();
	        List<Hanvondevice> sl = hwdev.list();
	        mav.addObject("sl", sl);
	        List<Institutions> s2 = instut.list();
	        mav.addObject("s2", s2);
	        mav.setViewName("hanvon_dev");
	        return mav;
	    }
		
public  List<Hanvondevice> back_dev(){
	return hwdev.list();
   }


@RequestMapping(value="hanvondev-add",method=RequestMethod.GET)
  public ModelAndView addHanvondev(){
    ModelAndView mav = new ModelAndView();
    List<Institutions> sl = instut.list();
    mav.addObject("sl", sl);
    mav.setViewName("hanvondev-add");
    return mav;
}


@RequestMapping(value="hanvondev-add/submit",method=RequestMethod.GET)
@ResponseBody
public String doAdddev(HttpServletRequest request, HttpServletResponse response){
	
	String institut_hao = request.getParameter("institut_hao");
	String sn = request.getParameter("sn");
	String ip = request.getParameter("ip");
	String subnetmask = request.getParameter("subnetmask");
	String gateip = request.getParameter("gateip");
	String class_id = request.getParameter("class_id");
	hwdev.insertOne(institut_hao,sn, ip, subnetmask, gateip, class_id);
	return "{\"success\":true}";
}
	}