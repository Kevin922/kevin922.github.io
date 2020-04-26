package com.kkkkkk.springtest;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class X implements InitializingBean, DisposableBean {

    @Autowired
    Y y;

    public X() {
        System.out.println("=========== X create");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=========== afterPropertiesSet method of x is called !! ");
    }

    /** 初始化方法的注解方式  等同与init-method=init **/
    @PostConstruct
    public void init(){
        System.out.println("=========== init custom method of x is called !!");
    }

    /** 销毁方法的注解方式  等同于destory-method=destory **/
    @PreDestroy
    public void destory() {
        System.out.println("=========== destory custom method of x is called !!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("=========== Destroy method of x bean called !! ");
    }
}
