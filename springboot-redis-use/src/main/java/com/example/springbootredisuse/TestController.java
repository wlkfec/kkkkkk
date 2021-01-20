package com.example.springbootredisuse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/base")
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public Object test() {
        rabbitTemplate.convertAndSend(MqConfig.EXCHANGE, MqConfig.demoProcessKey,
                "xxxxxxxxxxxxx");
        return Arrays.asList("xx", "cc");
    }

    public void init() throws Exception {
    }

}
