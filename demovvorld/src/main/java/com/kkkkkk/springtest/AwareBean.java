package com.kkkkkk.springtest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AwareBean implements ApplicationContextAware, BeanNameAware, BeanFactoryAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("=========== setBeanName method of AwareBeanImpl is called");
        System.out.println("=========== setBeanName:: Bean Name defined in context= " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("=========== setBeanFactory method of AwareBeanImpl is called");
        System.out.println("=========== setBeanFactory:: AwareBeanImpl singleton= " + beanFactory.isSingleton("awareBean"));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("=========== setApplicationContext method of AwareBeanImpl is called");
        System.out.println("=========== setApplicationContext:: Bean Definition Names= " + Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }
}