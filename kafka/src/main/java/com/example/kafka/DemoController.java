package com.example.kafka;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("")
    public String hello(){
        return "hello";
    }

    @PostMapping("send")
    public void send(){
        Message message = new Message()
                .setId(System.currentTimeMillis())
                .setMsg(UUID.randomUUID().toString())
                .setSendDate(new Date());
        Gson gson = new Gson();
        System.out.println(String.format("+++++++++++++++++++++  message = %s", gson.toJson(message)));
        kafkaTemplate.send("TestTopic", gson.toJson(message));
    }
}
