package com.example.client01.controller;

import com.example.client01.client.RemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RibbonClients
@RequestMapping("/client01")
public class ClientController {
    /*@Autowired
    HelloService helloService;*/

    @Autowired
    RemoteClient remoteClient;

/*
    @RequestMapping(value = "/consumer/a", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }*/

 /*   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String callServer() {
        return rabbionService.callServer();
    }*/

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public String callServer2() {
        return remoteClient.hello();
    }

   /* @RequestMapping(value = "/consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello2("DDD")).append("\n");
        sb.append(helloService.hello3("DDD", 30)).append("\n");
        sb.append(helloService.hello4(new User("DDD", 30))).append("\n");
        return sb.toString();
    }*/
}
