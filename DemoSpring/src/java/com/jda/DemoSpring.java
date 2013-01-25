/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jda;

/**
 *
 * @author j1013563
 */
public class DemoSpring {
    
   private String employee;

   public void setMessage(String message){
      this.employee  = message;
   }

   public void getMessage(){
      System.out.println("Current employee name is  : " + employee);
   }
    
}
