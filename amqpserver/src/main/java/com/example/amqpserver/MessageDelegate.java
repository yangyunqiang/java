package com.example.amqpserver;


public class MessageDelegate {

    public void consumeMessage(String messageBody) {
        System.err.println("默认方法, 消息内容:" + new String(messageBody));

    }

}
