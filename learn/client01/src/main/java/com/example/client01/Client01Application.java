package com.example.client01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
        "com.example.client01.controller",
        "com.example.client01.service",
        "com.example.client01.client",
        "com.example.client01.configer"
})
@EnableFeignClients
public class Client01Application {

    public static void main(String[] args) {
        SpringApplication.run(Client01Application.class, args);
    }

}
