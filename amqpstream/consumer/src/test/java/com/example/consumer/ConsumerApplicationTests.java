package com.example.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.test.context.web.WebAppConfiguration;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@WebAppConfiguration
class ConsumerApplicationTests {

    @Autowired
    private SinkSender sinkSender;

    @Test
    void contextLoads() {
        Message<String> data = MessageBuilder.withPayload("message").build();
        sinkSender.output().send(data);
    }

}
