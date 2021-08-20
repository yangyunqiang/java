package com.example.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.messaging.support.MessageBuilder;

import java.time.LocalTime;

/**
 * @author yyq
 * @date 2021/8/20 15:32
 */
@Component
@EnableBinding(Source.class)
public class ScheController {

    @Autowired
    private Source sink;

    @Scheduled(fixedRate = 5000)
    public void cronFunc() {
        LocalTime localTime = LocalTime.now();
        sink.output().send( MessageBuilder.withPayload(localTime.toString()).build());
    }
}
