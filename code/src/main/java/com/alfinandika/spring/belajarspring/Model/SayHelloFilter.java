package com.alfinandika.spring.belajarspring.Model;

import org.springframework.stereotype.Component;

@Component
public class SayHelloFilter {

    public String filter(String value){
        return value.toUpperCase();
    }
}
