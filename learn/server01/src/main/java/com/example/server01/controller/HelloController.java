package com.example.server01.controller;


import com.example.server01.pojo.dto.User;
import com.example.server01.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private TbUserService tbUserService;

    @GetMapping("/")
    public String sayHi() throws InterruptedException {
        //tbUserService.doUserInsert();
        //Thread.sleep(1000000);
        return "Hello Spring Boot";
    }

    @RequestMapping(value = "/2", method = RequestMethod.POST)
    public String hello2(@RequestBody String name) {
        return "Hello "+name;
    }
    @RequestMapping(value = "/3", method = RequestMethod.POST)
    public String hello3(@RequestBody String name) {
        return "Hello "+name;
    }

    /*@RequestMapping(value = "/3", method = RequestMethod.POST)
    @ResponseBody
    public User hello3(@RequestHeader("name") String name, @RequestHeader("age") Integer age){
        return new User(name,age);
    }

    @RequestMapping(value = "/4", method = RequestMethod.POST)
    public String hello4(@RequestBody User user){
        return "Hello "+user.getNama() +","+user.getAge();
    }*/
}
