package com.example.client01.service;

import com.example.client01.pojo.dto.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

public interface HelloService {
/*
    @RequestMapping("/")
    String hello();

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    String hello2(@RequestParam("name") String name);

    @RequestMapping(value = "/3", method = RequestMethod.GET)
    String hello3(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/4", method = RequestMethod.POST)
    String hello4(@RequestBody User user);*/

}
