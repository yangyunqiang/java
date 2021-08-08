package com.example.amqpserver.configer;

import com.example.amqpserver.MessageDelegate;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

//@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue001() {
        return new Queue("hello", true); //队列持久
    }

    @Bean
    public SimpleMessageListenerContainer messageContainer(ConnectionFactory connectionFactory) {

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        //添加多个队列进行监听
        container.setQueues(queue001());

        container.setPrefetchCount(5);
        //当前消费者数量
        container.setConcurrentConsumers(2);
        //最大消费者数量
        container.setMaxConcurrentConsumers(5);
        //设置重回队列，一般设置false
        container.setDefaultRequeueRejected(false);
        //设置自动签收机制
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);

        //设置listener外露
        container.setExposeListenerChannel(true);
        //消费端标签生成策略
        container.setConsumerTagStrategy(new ConsumerTagStrategy() {
            @Override
            public String createConsumerTag(String queue) {
                //每个消费端都有自己独立的标签
                return queue + "_" + UUID.randomUUID().toString();
            }
        });

        //消息监听
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                String msg = new String(message.getBody());

                Thread.sleep(2000);
                System.err.println(Thread.currentThread().getId() + "----------消费者: " + msg);
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);

            }
        });

       /* MessageListenerAdapter adapter = new MessageListenerAdapter(new MessageDelegate());
        adapter.setDefaultListenerMethod("consumeMessage");
        container.setMessageListener(adapter);*/

        return container;
    }


}
