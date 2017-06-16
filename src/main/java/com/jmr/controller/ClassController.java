package com.jmr.controller;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jmr.model.Class;
import com.jmr.service.IClassService;

@Controller
@RequestMapping("")
public class ClassController {
	@Autowired
	IClassService classService;
	
	@RequestMapping(value="class-list/data-source",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doClassListDataSourcePOST(@RequestParam int draw,@RequestParam int start,@RequestParam int length){
		return classService.getClassesDataTest(draw, start, length);
	}
	
	@RequestMapping(value="class-list/test",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doClassListDataSourceTest(@RequestParam int draw,@RequestParam int start,@RequestParam int length,@RequestParam int id){
		return classService.getClassesDataWithId(draw, start, length, id);
	}
	
//	@RequestMapping(value="class-list/test",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String,Object> doClassListDataSourc(@RequestParam int draw,@RequestParam int start,@RequestParam int length){
//		return classService.getClassesDataTest(draw, start, length);
//	}
	
	@RequestMapping(value="class-series-list/data-source",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doClassSeriesListDataSourcePOST(@RequestParam int draw,@RequestParam int start,@RequestParam int length){
		return classService.getClassSeriesData(draw, start, length);
	}
	
	@RequestMapping(value="course-list/data-source",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doCourseListDataSourcePOST(@RequestParam int draw,@RequestParam int start,@RequestParam int length){
		return classService.getCourseData(draw, start, length);
	}
	
	@RequestMapping(value="class-list",method=RequestMethod.GET)
	public ModelAndView doClassListGET(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("class-list");
	    return mav;
	}
	
	@RequestMapping(value="class-series-list",method=RequestMethod.GET)
	public ModelAndView doClassSeriesListGET(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("class-series-list");
	    return mav;
	}
	
	@RequestMapping(value="course-list",method=RequestMethod.GET)
	public ModelAndView doCourseListGET(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("course-list");
	    return mav;
	}
	
//	@RequestMapping(value="class-list",method=RequestMethod.GET)
//    public ModelAndView listClass(){
//        ModelAndView mav = new ModelAndView();
//        List<Class> sl = t.list();
//        
//        // 放入转发参数
//        mav.addObject("sl", sl);
//        // 放入jsp路径
//        mav.setViewName("class-list");
//        return mav;
//    }
//	
//	@RequestMapping(value="class-application",method=RequestMethod.POST)
//	@ResponseBody
//	public String doPost(@RequestParam int cid){
//		t.updateOnesState(cid, 2);
//		return "{\"success\":false}";
//	}
//	
//	@RequestMapping(value="class-application-plus",method=RequestMethod.POST)
//	@ResponseBody
//	public String doPostPlus(@RequestParam int cid){
//		t.updateOnesState(cid, 3);
//		return "{\"success\":false}";
//	}
//	
//	@RequestMapping(value="class-list/delete",method=RequestMethod.POST)
//	@ResponseBody
//	public String doDelete(HttpServletRequest request, HttpServletResponse response){
//		String s = request.getParameter("id");
//		try {
//		    int b = Integer.valueOf(s).intValue();
//		    t.deleteOne(b);
//		    return "{\"success\":true}";
//		} catch (NumberFormatException e) {
//		    e.printStackTrace();
//		}
//		return "{\"success\":false}";
//	}
//	
//	@RequestMapping(value="class-list/deleteall",method=RequestMethod.POST)
//	@ResponseBody
//	public String doDeleteAll( @RequestParam (value = "ids[]",required = false,defaultValue = "") String[] ids){
//		int lens = ids.length;
//		for(int i=0;i<lens;i++){
//			try {
//			    int b = Integer.valueOf(ids[i]).intValue();
//			    t.deleteOne(b);
//			} catch (NumberFormatException e) {
//			    e.printStackTrace();
//			    return "{\"success\":false}";
//			}
//		}
//		return "{\"success\":true}";
//	}
//	
//	@RequestMapping("class-application")
//    public ModelAndView classApplication(){
//        ModelAndView mav = new ModelAndView();
//        
//        List<Class> sl = t.list();
//        
//        // 放入转发参数
//        mav.addObject("sl", sl);
//        
//        // 放入jsp路径
//        mav.setViewName("class-application");
//        return mav;
//    }
//	
//	@RequestMapping("class-application-plus")
//    public ModelAndView classApplicationPlus(){
//        ModelAndView mav = new ModelAndView();
//        
//        List<Class> sl = t.listApplication();
//        
//        // 放入转发参数
//        mav.addObject("sl", sl);
//        
//        // 放入jsp路径
//        mav.setViewName("class-application-plus");
//        return mav;
//    }
//	
//	@RequestMapping(value="class-update",method=RequestMethod.GET)
//    public ModelAndView classUpdate(HttpServletRequest request, HttpServletResponse response){
//		ModelAndView mav = new ModelAndView();
//		
//		String id = request.getParameter("id");
//		mav.addObject("id",id);
//		
//        // ����jsp·��
//        mav.setViewName("class-update");
//        return mav;
//	}
//	
//	@RequestMapping(value="class-update/submit",method=RequestMethod.GET)
//	@ResponseBody
//	public String doUpdate(HttpServletRequest request, HttpServletResponse response){
//		
//		String classid = request.getParameter("classid");
//		String classname = request.getParameter("classname");
//		String applynumber = request.getParameter("applynumber");
//		String startdate = request.getParameter("startdate");
//		String enddate = request.getParameter("enddate");
//		String remark = request.getParameter("remark");
//		String applyperson = request.getParameter("applyperson");
//		t.updateOne(classid, classname, applynumber, startdate, enddate, remark, applyperson);
//		return "{\"success\":true}";
//	}
//	
//	@RequestMapping(value="class-add",method=RequestMethod.GET)
//    public ModelAndView classAdd(HttpServletRequest request, HttpServletResponse response){
//		ModelAndView mav = new ModelAndView();
//		
//        // ����jsp·��
//        mav.setViewName("class-add");
//        return mav;
//	}
//	
//	@RequestMapping(value="class-add/submit",method=RequestMethod.GET)
//	@ResponseBody
//	public String doAdd(HttpServletRequest request, HttpServletResponse response){
//			
//		String classname = request.getParameter("classname");
//		String applynumber = request.getParameter("applynumber");
//		String startdate = request.getParameter("startdate");
//		String enddate = request.getParameter("enddate");
//		String remark = request.getParameter("remark");
//		String applyperson = request.getParameter("applyperson");
//		t.insertOne(classname, applynumber, startdate, enddate, remark, applyperson);
//		return "{\"success\":true}";
//	}
	
	public static Map<String, Object> transBean2Map(Object obj) {  
		  
        if(obj == null){  
            return null;  
        }          
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                // ����class����  
                if (!key.equals("class")) {  
                    // �õ�property��Ӧ��getter����  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
  
                    map.put(key, value);  
                }  
  
            }  
        } catch (Exception e) {  
            System.out.println("transBean2Map Error " + e);  
        }  
  
        return map;  
  
    }  
}
