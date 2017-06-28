/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jmr.hanvonkao.server;

import java.io.IOException;
import java.util.Locale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Splash
 */
public class HwTcpServer extends  Thread {
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			 System.out.println("fffffffffffff");
             SpringhwController controller = new SpringhwController();
		     controller.startListenerAction();
	
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
  
    

    public static void main(String[] args) throws Exception {
    	 try {
    		 System.out.println("fffffffffffff");
             SpringhwController controller = new SpringhwController();
            
                 controller.startListenerAction();
    
         } 
         catch (IOException ex) {
            ex.printStackTrace();
         }
    }
    
}
