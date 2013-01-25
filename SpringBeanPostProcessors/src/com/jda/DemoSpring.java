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

   public void setEmployee(String employee){
      this.employee  = employee;
   }

   public String getEmployee(){
     return employee;
   }
   public void init(){
      System.out.println("Bean is going through init.");
   }
   public void destroy(){
      System.out.println("Bean will destroy now.");
   }
    
}
