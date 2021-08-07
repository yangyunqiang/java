package com.example.client01.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="SERVER01")
public interface RemoteClient {

    @GetMapping("/")
    String hello();
}
