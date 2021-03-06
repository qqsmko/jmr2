package com.jmr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jmr.model.Attendance;
import com.jmr.model.Student;
import com.jmr.model.Teacher;
import com.jmr.service.IAttendanceService;
import com.jmr.service.IStudentService;

@Controller
@RequestMapping("")
public class AttendanceController {
	@Autowired
	IAttendanceService attendanceService;
	@Autowired
	IStudentService studentService;
	
	@RequestMapping("attendance-list")
    public ModelAndView listStudent(){
        ModelAndView mav = new ModelAndView();
//        List<Attendance> sl = attendanceService.list();
//        List<String> sid = new ArrayList();
//        int lens = sl.size();
//		for(int i=0;i<lens;i++){
//			Student temp = studentService.getOne(sl.get(i).getStudentid());
//			sid.add(temp.getName());
//		}
//		
//        // 放入转发参数
//        mav.addObject("sl", sl);
//        mav.addObject("sid",sid);
        // 放入jsp路径
        mav.setViewName("attendance-list");
        return mav;
    }
	
	@RequestMapping(value="attendance-submit",method=RequestMethod.POST)
	@ResponseBody
	public String doAttendanceSubmit(@RequestBody Attendance attendance){
		attendance.setDatatime(new Date(new Date().getTime()));
//		attendanceService.insertOne(attendance);
		return "{\"success\":true}";
	}
	
	@RequestMapping("attendance-get")
    public ModelAndView attendanceGet(){
        ModelAndView mav = new ModelAndView();
//        List<Student> sl = studentService.list();
//        
//        // 放入转发参数
//        mav.addObject("sl", sl);
        // 放入jsp路径
        mav.setViewName("attendance-get");
        return mav;
    }
	
	@RequestMapping(value="attendance-add/submit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doAttendanceAddSubmitPOST(@RequestBody Attendance attendance){
//		Map<String,Object> ansMap = new HashMap<String,Object>();
//		ansMap.put("successhahahah",true);
//		return ansMap;
		return attendanceService.InsertAttendance(attendance);
	}
	
}
