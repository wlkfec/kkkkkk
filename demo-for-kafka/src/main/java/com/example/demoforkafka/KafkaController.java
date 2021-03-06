package com.example.demoforkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @SuppressWarnings("all")
    @GetMapping("/message/send")
    public boolean send(@RequestParam String message){
        // 指定分区
        kafkaTemplate.send("testTopic",message);
        return true;
    }

}