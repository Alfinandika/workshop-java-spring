package com.alfinandika.spring.belajarspring.Service;

import com.alfinandika.spring.belajarspring.Model.User;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@Validated
public class UserService {

    public void save(@Valid User user){
        System.out.println("sukses menyimpan user baru");
    }

    public  void getById(@NotBlank String id){
        System.out.println("sukses get By Id");
    }
}
