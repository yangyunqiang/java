package com.example.server02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {
		"com.example.server02.controller",
		"com.example.server02.service"
})

@EnableDiscoveryClient
public class Server02Application {

	public static void main(String[] args) {
		SpringApplication.run(Server02Application.class, args);
	}

}
