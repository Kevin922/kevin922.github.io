package com.kkkkkk.springtest;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("=========== Post Process Before Initialization method is called : Bean Name " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("=========== Post Process After Initialization method is called : Bean Name " + beanName);
        return bean;
    }
}
