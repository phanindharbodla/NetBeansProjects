/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jda;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author j1013563
 */
public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/jda/beans.xml");
        DemoSpring obj = (DemoSpring) context.getBean("whoSthis");
        System.out.println(obj.getEmployee());
        context.registerShutdownHook();
    }
}
