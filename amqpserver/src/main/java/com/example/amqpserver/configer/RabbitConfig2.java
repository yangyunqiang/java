package com.example.amqpserver.configer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Header;

import java.io.IOException;
import java.util.UUID;

@Configuration
public class RabbitConfig2 {

    @RabbitListener( queues = "hello", concurrency = "4", ackMode = "MANUAL")
    public void multiConsumer(String data, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException, InterruptedException {
        System.out.println(Thread.currentThread().getId() +"-multiConsumer: " + data);
        Thread.sleep(2000);
        channel.basicAck(deliveryTag, true);
    }

}
