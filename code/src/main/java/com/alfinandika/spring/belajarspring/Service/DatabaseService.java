package com.alfinandika.spring.belajarspring.Service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DatabaseService {

    @PostConstruct
    public void openConnection(){
        System.out.println("MEMBUKA KONEKSI KE DATABASE");
    }

    @PreDestroy
    public void closeConnection(){
        System.out.println("MENUTUP KONEKSI KE DATABASE");
    }
}
