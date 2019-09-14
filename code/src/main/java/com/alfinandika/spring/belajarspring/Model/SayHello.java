package com.alfinandika.spring.belajarspring.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class SayHello implements MessageSourceAware {

    private SayHelloFilter sayHelloFilter;

    private MessageSource messageSource;

    @Autowired
    public SayHello(SayHelloFilter sayHelloFilter) {
        this.sayHelloFilter = sayHelloFilter;
    }

    public String sayHello(String name){
        return sayHelloFilter.filter( messageSource.getMessage("hello", null, Locale.getDefault())+name);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
