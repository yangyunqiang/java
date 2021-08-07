package com.example.server02.controller;

import com.example.server02.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private TbUserService tbUserService;

    @GetMapping("/")
    public String sayHi() {
        //tbUserService.doUserInsert();
        return "Hello Spring Boot 23   1 2 3 4";
    }
}
