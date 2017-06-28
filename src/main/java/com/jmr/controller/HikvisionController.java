package com.jmr.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jmr.model.Hikvisiondev;
import com.jmr.model.Institutions;
import com.jmr.service.IHikvisiondeviceService;
import com.jmr.service.IInstitutionsService;

@Controller
@RequestMapping("")
public class HikvisionController {
	@Autowired
	IHikvisiondeviceService ihkvs;
	@Autowired
	IInstitutionsService instut;
	
	
	@RequestMapping(value="hikvision_list",method=RequestMethod.GET)
    public ModelAndView listHikvision_dev(){

        ModelAndView mav = new ModelAndView();
        List<Hikvisiondev> sl = ihkvs.list();
        mav.addObject("sl", sl);
        List<Institutions> s2 = instut.list();
        mav.addObject("s2", s2);
        mav.setViewName("hikvision_list");
        return mav;
    }
	

@RequestMapping(value="hikvision-add",method=RequestMethod.GET)
public ModelAndView addHikvisiondev(){
ModelAndView mav = new ModelAndView();
List<Institutions> sl = instut.list();
mav.addObject("sl", sl);
mav.setViewName("hikvision-add");
return mav;
}


@RequestMapping(value="hikvision-add/submit",method=RequestMethod.GET)
@ResponseBody
public String doAdddev(HttpServletRequest request, HttpServletResponse response){

String dev_hao = request.getParameter("dev_hao");
String iinstut_hao = request.getParameter("iinstut_hao");
String class_hao = request.getParameter("class_hao");
String ip_adr = request.getParameter("ip_adr");
String sp=request.getParameter("s_port");
int  s_port=0;
if (!(sp.equals("")||sp.equals(null)))
s_port =Integer.valueOf(sp);
String sub_smask = request.getParameter("sub_smask");
String gate_ip = request.getParameter("gate_ip");
int    http_port =Integer.valueOf( request.getParameter("http_port"));
String user_name = request.getParameter("user_name");
String user_pwd = request.getParameter("user_pwd");
String dev_scipt = request.getParameter("dev_scipt");
int  stat_v =0;// Integer.valueOf(request.getParameter("stat_v"));
String save_adr =null;// request.getParameter("save_adr");
ihkvs.insertOne(dev_hao,iinstut_hao,class_hao,ip_adr, s_port,sub_smask,
		gate_ip,http_port,user_name,user_pwd,dev_scipt,stat_v,save_adr);
return "{\"success\":true}";
}

@RequestMapping(value="hkvs_play",method=RequestMethod.GET)
public ModelAndView play_hkvs(){
	ModelAndView mav = new ModelAndView();
    List<Hikvisiondev> sl = ihkvs.list();
    //System.out.println();
    mav.addObject("sl", sl);   
    mav.setViewName("hkvs_play");
    return mav;
}

@RequestMapping(value="hikvision_update",method=RequestMethod.GET)
public ModelAndView hikvsUpdate(HttpServletRequest request, HttpServletResponse response){
	ModelAndView mav = new ModelAndView();
    List<Institutions> sl = instut.list();
    mav.addObject("sl", sl);
    String dev_hao = request.getParameter("dev_hao");
	mav.addObject("dev_hao",dev_hao);
	Hikvisiondev hks=ihkvs.getOne(dev_hao);
	mav.addObject("cur",hks);
	mav.setViewName("hikvision_update");
    return mav;
}

@RequestMapping(value="hikvision_update/submit",method=RequestMethod.GET)
@ResponseBody
public String hkvsdoUpdate(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
	//request.setCharacterEncoding("UTF-8"); 
	String dev_hao = request.getParameter("dev_hao");
	String iinstut_hao = request.getParameter("iinstut_hao");
	String class_hao = request.getParameter("class_hao");
	String ip_adr = request.getParameter("ip_adr");
	String sp=request.getParameter("s_port");
	int  s_port=0;
	if (!(sp.equals("")||sp.equals(null)))
	s_port =Integer.valueOf(sp);
	String sub_smask = request.getParameter("sub_smask");
	String gate_ip = request.getParameter("gate_ip");
	int    http_port =Integer.valueOf( request.getParameter("http_port"));
	String user_name = request.getParameter("user_name");
	String user_pwd = request.getParameter("user_pwd");
	String dev_scipt = request.getParameter("dev_scipt");
	 System.out.println(dev_scipt);
	int  stat_v =0;// Integer.valueOf(request.getParameter("stat_v"));
	String save_adr =null;// request.getParameter("save_adr");
	ihkvs.updateOne(dev_hao,iinstut_hao,class_hao,ip_adr, s_port,sub_smask,
			gate_ip,http_port,user_name,user_pwd,dev_scipt,stat_v,save_adr);
	return "{\"success\":true}";
}


@RequestMapping(value="hikvision_list/delete",method=RequestMethod.POST)
@ResponseBody
public String doDelete(HttpServletRequest request, HttpServletResponse response){
	String s = request.getParameter("id");
	System.out.println(s);
	try {
	    ihkvs.deleteOne(s);
	    return "{\"success\":true}";
	} catch (NumberFormatException e) {
	    e.printStackTrace();
	}
	return "{\"success\":false}";
}

}