package com.example.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(value = {SinkSender.class})
public class SinkReceiver {


    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        System.out.println("received:" + payload);
    }
}
