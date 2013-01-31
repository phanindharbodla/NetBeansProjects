package com.jda;


/**
 *
 * @author Phanindhar Bodla
 */

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

public class InitDemoSpring implements BeanPostProcessor {
 
    @Override
   public Object postProcessBeforeInitialization(Object bean,
                 String beanName) throws BeansException {
      System.out.println("BeforeInitialization : " + beanName);
      return bean;  // you can return any other object as well
   }

    @Override
   public Object postProcessAfterInitialization(Object bean,
                 String beanName) throws BeansException {
      System.out.println("AfterInitialization : " + beanName);
      return bean;  // you can return any other object as well
   }

}