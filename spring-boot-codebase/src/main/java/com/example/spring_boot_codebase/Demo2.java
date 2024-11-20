package com.example.spring_boot_codebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo2 {

    @Autowired
    private Dog dog;

    @GetMapping("/ok")
    public String getEat() {
        return dog.eat();
    }
}
