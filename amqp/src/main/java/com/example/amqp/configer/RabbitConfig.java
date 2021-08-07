package com.example.amqp.configer;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Map;

@Configuration
public class RabbitConfig {


    @Bean
    public Queue helloQueue() {
        System.out.println("create rabbit queue");
        return new Queue("hello");
    }

    @Bean
    public Queue helloQueue1() {
        System.out.println("create rabbit queue1");
        return new Queue("demohello1");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("demo1");
    }

    @Bean Binding bind001() {
        return BindingBuilder.bind(helloQueue1()).to(directExchange()).with("hello1");
    }



}
