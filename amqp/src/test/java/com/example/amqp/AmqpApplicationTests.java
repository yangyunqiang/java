package com.example.amqp;

import com.example.amqp.rabbit.Sender;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AmqpApplicationTests {


    @Autowired
    private Sender sender;

    @Test
    public void hello() throws Exception {
        sender.send();
    }

    @Test
    void contextLoads() {




    }

}
