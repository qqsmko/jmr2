package com.jmr.hanvonkao.server;

import java.io.File;
import java.io.IOException;  
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  




public  class ProcedureObject extends HttpServlet {
	
	  @Override
	      public void init() throws ServletException { 
		  HwTcpServer fff=new HwTcpServer();
		  fff.start();
	    	}

	     
}


