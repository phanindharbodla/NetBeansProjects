/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jda;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author j1013563
 */
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/jda/beans.xml");
        DemoSpring obj1= (DemoSpring) context.getBean("whoSthis");
        obj1.setEmployee("Indira");
        System.out.println(obj1.getEmployee());
        DemoSpring obj2= (DemoSpring) context.getBean("whoSthis");
        System.out.println(obj2.getEmployee());
        // so with out setting the obj2 value we are getting the value coz the session of obj is singleton which is setted at the obj1 intiation 
    }
}
