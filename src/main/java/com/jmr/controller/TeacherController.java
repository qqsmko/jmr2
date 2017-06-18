package com.jmr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jmr.model.Course;
import com.jmr.model.Teacher;
import com.jmr.service.ITeacherService;

@Controller
@RequestMapping("")
public class TeacherController {
	@Autowired
	ITeacherService teacherService;
	
	@RequestMapping(value="teacher-list",method=RequestMethod.GET)
    public ModelAndView listTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("teacher-list");
        return mav;
    }
	
	@RequestMapping(value="teacher-list/data-source",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doDataTestPOST(@RequestParam int draw,@RequestParam int start,@RequestParam int length,@RequestParam(value="search[value]") String search){
		return teacherService.getTeacherData(draw, start, length,search);
	}
	
	@RequestMapping(value="teacher-add",method=RequestMethod.GET)
    public ModelAndView teacherAdd(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
        mav.setViewName("teacher-add");
        return mav;
	}
	
	@RequestMapping(value="teacher-add/submit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doTeacherAddSubmitPOST(@RequestBody Map<String,Object> json){
	    return teacherService.InsertTeacher(json);
	}
	
	@RequestMapping(value="teacher-list/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doDelete(@RequestParam int id){
		return teacherService.deleteTeacher(id);
	}
	
	@RequestMapping(value="teacher-list/deleteall",method=RequestMethod.POST)
	@ResponseBody
	public String doDeleteAll( @RequestParam (value = "ids[]",required = false,defaultValue = "") String[] ids){
		int lens = ids.length;
		for(int i=0;i<lens;i++){
			try {
			    int b = Integer.valueOf(ids[i]).intValue();
			    teacherService.deleteTeacher(b);
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			    return "{\"success\":false}";
			}
		}
		return "{\"success\":true}";
	}
	
	@RequestMapping(value="teacher-update",method=RequestMethod.GET)
    public ModelAndView teacherUpdate(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		Teacher teacher = teacherService.getTeacherById(id);
		mav.addObject("teacher",teacher);
        mav.setViewName("teacher-update");
        return mav;
	}
	
	@RequestMapping(value="teacher-update/submit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doUpdate(@RequestBody Teacher teacher){
		return teacherService.updateTeacher(teacher);
	}
}