
package com.jda;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * @author Phanindhar Bodla
 */
public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/jda/beans.xml");
        //DemoSpring obj = (DemoSpring) context.getBean("whoSthis");
        DemoBean objBean = (DemoBean) context.getBean("whatSay");
        System.out.println("Author is :    "+objBean.getEmployee());
        System.out.println("Code is for  : "+objBean.getMessage());
        context.registerShutdownHook();
    }
}
