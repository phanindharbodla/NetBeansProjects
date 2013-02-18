
package com.jda;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * @author Phanindhar Bodla
 */
public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/jda/beans.xml");
        
        TextEditor myDocument = (TextEditor) context.getBean("textEditor");
        myDocument.spellCheck();
        context.registerShutdownHook();
    }
}
