package com.jmr.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;  

@Controller
@RequestMapping("")
public class LoginController {

	@RequestMapping(value="login",method=RequestMethod.GET)
    public ModelAndView doLoginGET(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
    public void doLoginPOST(HttpServletRequest r, HttpServletResponse w) throws Throwable {
        System.out.println("POST login");

        String userName = r.getParameter("username");
        String password = r.getParameter("password");
        
        w.addCookie(new Cookie("username", userName));
        w.addCookie(new Cookie("password", password));

        w.sendRedirect("index");
    }
}
