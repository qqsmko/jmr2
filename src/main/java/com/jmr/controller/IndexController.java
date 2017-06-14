package com.jmr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jmr.service.IUtilService;

@Controller
@RequestMapping("")
public class IndexController {
	@Autowired
	IUtilService utilService;
	
	@RequestMapping("index")
    public ModelAndView listStudent(){
        ModelAndView mav = new ModelAndView();
        
        // 放入jsp路径
        mav.setViewName("index");
        return mav;
    }
	
	@RequestMapping(value="index",method=RequestMethod.POST)
    public ModelAndView doIndexPOST(@RequestParam String username,@RequestParam String password){
    	ModelAndView mav = new ModelAndView();
    	int ans = utilService.checkAccount(username, password);
    	if(ans!=0){
    		if(ans==1){
    			mav.addObject("type","root");
    		}else if(ans==2){
    			mav.addObject("type","teacher");
    		}else if(ans==3){
    			mav.addObject("type","admin");
    		}
    		mav.setViewName("index");
    		return mav;
    	}
		
        mav.setViewName("redirect:/login");
        return mav;
    }
	
	@RequestMapping("welcome")
    public ModelAndView doWelcomeGET(){
        ModelAndView mav = new ModelAndView();
        
        // 放入jsp路径
        mav.setViewName("welcome");
        return mav;
    }
}
