package com.jmr.controller;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jmr.model.Class;
import com.jmr.model.Course;
import com.jmr.service.IClassService;

@Controller
@RequestMapping("")
public class ClassController {
	@Autowired
	IClassService classService;
	
	/*--------------------------------------------------------*/
	//                         Class
	/*--------------------------------------------------------*/
	@RequestMapping(value="class-list",method=RequestMethod.GET)
	public ModelAndView doClassListGET(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("class-list");
	    return mav;
	}
	
	@RequestMapping(value="class-list/data-source",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doClassListDataSourcePOST(@RequestParam int draw,@RequestParam int start,@RequestParam int length,@RequestParam(value="search[value]") String search){
		return classService.getClassesDataTest(draw, start, length, search);
	}
	
//	@RequestMapping(value="class-list/test",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String,Object> doClassListDataSourceTest(@RequestParam int draw,@RequestParam int start,@RequestParam int length,@RequestParam int id){
//		return classService.getClassesDataWithId(draw, start, length, id);
//	}
	
	@RequestMapping(value="class-add",method=RequestMethod.GET)
	public ModelAndView doClassAddGET(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("class-add");
		return mav;
	}
	
	@RequestMapping(value="class-add/submit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doCourseAddSubmitPOST(@RequestBody Class classes){
	    System.out.println(classes.getStartTime());
		return classService.insertClass(classes);
	}
	
	@RequestMapping(value="class-list/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doClassDelete(@RequestParam int id){
		return classService.deleteClass(id);
	}
	
	@RequestMapping(value="class-list/deleteall",method=RequestMethod.POST)
	@ResponseBody
	public String doClassDeleteAll( @RequestParam (value = "ids[]",required = false,defaultValue = "") String[] ids){
		int lens = ids.length;
		for(int i=0;i<lens;i++){
			try {
			    int b = Integer.valueOf(ids[i]).intValue();
			    classService.deleteClass(b);
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			    return "{\"error\":\"解析数组错误\"}";
			}
		}
		return "{\"success\":true}";
	}
	
	
	@RequestMapping(value="class-update",method=RequestMethod.GET)
	public ModelAndView doClassUpdateGET(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		Class classes = classService.getClassById(id);
		mav.addObject("classes",classes);
		mav.setViewName("class-update");
	    return mav;
	}
	
	@RequestMapping(value="class-update/submit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doClassUpdateSubmitPOST(@RequestBody Class classes){
		return classService.updateClass(classes);
	}
	
	
	/*--------------------------------------------------------*/
	//                       Class-Series
	/*--------------------------------------------------------*/
//	@RequestMapping(value="class-series-list/data-source",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String,Object> doClassSeriesListDataSourcePOST(@RequestParam int draw,@RequestParam int start,@RequestParam int length){
//		return classService.getClassSeriesData(draw, start, length);
//	}
	
//	@RequestMapping(value="class-series-list",method=RequestMethod.GET)
//	public ModelAndView doClassSeriesListGET(){
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("class-series-list");
//	    return mav;
//	}
	
	
	
	
	/*--------------------------------------------------------*/
	//                         Course
	/*--------------------------------------------------------*/
	@RequestMapping(value="course-list",method=RequestMethod.GET)
	public ModelAndView doCourseListGET(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("course-list");
	    return mav;
	}
	
	@RequestMapping(value="course-list/data-source",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doCourseListDataSourcePOST(@RequestParam int draw,@RequestParam int start,@RequestParam int length,@RequestParam(value="search[value]") String search){
		return classService.getCourseData(draw, start, length, search);
	}
	
	@RequestMapping(value="course-add",method=RequestMethod.GET)
	public ModelAndView doCourseAddGET(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("course-add");
	    return mav;
	}
	
	@RequestMapping(value="course-add/submit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doCourseAddSubmitPOST(@RequestBody Course course){
	    return classService.insertCourse(course);
	}
	
	@RequestMapping(value="course-list/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doCourseDelete(@RequestParam int id){
		return classService.deleteCourse(id);
	}
	
	@RequestMapping(value="course-list/deleteall",method=RequestMethod.POST)
	@ResponseBody
	public String doCourseDeleteAll( @RequestParam (value = "ids[]",required = false,defaultValue = "") String[] ids){
		int lens = ids.length;
		for(int i=0;i<lens;i++){
			try {
			    int b = Integer.valueOf(ids[i]).intValue();
			    classService.deleteCourse(b);
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			    return "{\"error\":\"解析数组错误\"}";
			}
		}
		return "{\"success\":true}";
	}
	
	@RequestMapping(value="course-update",method=RequestMethod.GET)
	public ModelAndView doCourseUpdateGET(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		Course course = classService.getCourseById(id);
		mav.addObject("course",course);
		mav.setViewName("course-update");
	    return mav;
	}
	
	@RequestMapping(value="course-update/submit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doCourseUpdateSubmitPOST(@RequestBody Course course){
		return classService.updateCourse(course);
	}
	
	
	
	
	/*--------------------------------------------------------*/
	//                    Class-Application
	/*--------------------------------------------------------*/
	
	@RequestMapping(value="class-application",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doPost(@RequestParam int id){
		return classService.submitApplyClass(id);
	}
	
	@RequestMapping(value="class-application-plus",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doPostPlus(@RequestParam int id,@RequestParam boolean ok){
		if(ok)
			return classService.checkApplyClass(id);
		else
			return classService.rejectApplyClass(id);
	}
	
	@RequestMapping(value="class-application",method=RequestMethod.GET)
    public ModelAndView classApplication(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("class-application");
        return mav;
    }
	
	@RequestMapping(value="class-application-plus",method=RequestMethod.GET)
    public ModelAndView classApplicationPlus(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("class-application-plus");
        return mav;
    }
	
	@RequestMapping(value="class-application-plus/data-source",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> classApplicationPlusDataSource(@RequestParam int draw,@RequestParam int start,@RequestParam int length,@RequestParam(value="search[value]") String search){
        return classService.getClassesDataWithState(draw, start, length, search, 1);
    }

	/*--------------------------------------------------------*/
	//                    		Util
	/*--------------------------------------------------------*/
	
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
  
                // 过滤class属性  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
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
