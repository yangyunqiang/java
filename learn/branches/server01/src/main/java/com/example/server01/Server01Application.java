package com.example.server01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {
		"com.example.server01.controller",
		"com.example.server01.service"
})

@EnableDiscoveryClient
public class Server01Application {

	public static void main(String[] args) {
		SpringApplication.run(Server01Application.class, args);
	}

}
