package com.aem.orderservice.Services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test-topic" ,groupId = "groupe 1")
    public void listen (String message){
        System.out.println(message);
    }

}
