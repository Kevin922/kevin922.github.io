package com.kkkkkk.springtest;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Y implements InitializingBean, DisposableBean {

    @Autowired
    X x;

    public Y() {
        System.out.println("=========== Y create");
    }

    /** 初始化方法的注解方式  等同与init-method=init **/
    @PostConstruct
    public void init(){
        System.out.println("=========== init custom method of y is called !!");
    }

    /** 销毁方法的注解方式  等同于destory-method=destory **/
    @PreDestroy
    public void destory() {
        System.out.println("=========== destory custom method of y is called !!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=========== afterPropertiesSet method of y is called !! ");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("=========== Destroy method of y bean called !! ");
    }
}
