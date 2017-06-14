package com.jmr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jmr.service.impl.UtilService;  

@Controller
@RequestMapping("")
public class LoginController {

	@RequestMapping(value="login",method=RequestMethod.GET)
    public ModelAndView doLoginGET(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
	
	
}
