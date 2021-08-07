package com.example.server01;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
		"com.example.server01.controller",
		"com.example.server01.service",
		"com.example.server01.config"
})

@EnableDiscoveryClient
public class Server01Application {

	public static void main(String[] args) {
		SpringApplication.run(Server01Application.class, args);
	}

	/*@Bean
	MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName){
		return registry -> registry.config().commonTags("application", applicationName);
	}*/

}
