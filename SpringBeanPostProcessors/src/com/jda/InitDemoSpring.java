package com.jda;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 * @author Phanindhar Bodla
 */
public class InitDemoSpring implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean,
            String beanName) throws BeansException {
        System.out.println("BeforeInitialization : " + beanName);
        return bean;  // you can return any other object as well or do anything before intalization of bean 
    }

    @Override
    public Object postProcessAfterInitialization(Object bean,
            String beanName) throws BeansException {
        System.out.println("AfterInitialization : " + beanName);
        return bean;  // you can return any other object as well or do anything after intalization of bean 
    }
}
