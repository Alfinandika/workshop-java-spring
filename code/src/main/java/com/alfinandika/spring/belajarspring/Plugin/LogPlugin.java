package com.alfinandika.spring.belajarspring.Plugin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

@Component
public class LogPlugin extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Telah dibuat bean dengan nama : "+beanName+" dengan type : "+bean.getClass());
        return bean;
    }
}
