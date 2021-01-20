package com.example.springbootredisuse;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.IOException;

@Slf4j
public class MqListener {

    @RabbitListener(queues = {"my_sp_queue"}, concurrency = "16")
    public void listen(@Payload String m, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        try {
            log.info("consumer message ----- {}", m);
                channel.basicAck(deliveryTag, false);
        }catch (Exception e) {
//            channel.basicReject(deliveryTag, true);
//            channel.basicReject(deliveryTag, false);
        }
    }
}