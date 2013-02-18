
package com.jda;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * @author Phanindhar Bodla
 */
public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/jda/beans.xml");
        School bps = (School) context.getBean("school");
        bps.getTeachersNames();
        bps.getTeacherSubjects();
        bps.getTeachersIds();
        bps.getTimetable();
        context.registerShutdownHook();
    }
}
