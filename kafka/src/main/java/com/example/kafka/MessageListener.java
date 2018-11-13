package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @KafkaListener(topics="TestTopic")
    public void handler(String content){
        System.out.println(String.format("【Received Message From 'myTopic'】: {%s}", content));
    }
}
