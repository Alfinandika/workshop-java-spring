package com.alfinandika.spring.belajarspring.Model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DataBean implements ApplicationContextAware {

    private String value;

    private  ApplicationContext context;

    public DataBean(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @PostConstruct
    public void init(){
        System.out.println("init databean = "+value);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy databean = "+value);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void doSomething(){
        if(context != null){
            System.out.println("OK, Contect Ada!");
        }else{
            System.out.println("NO, Contect tidak Ada!");
        }
    }
}
