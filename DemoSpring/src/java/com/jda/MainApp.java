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
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DemoSpring obj = (DemoSpring) context.getBean("helloWorld");
        obj.getMessage();
    }
}
