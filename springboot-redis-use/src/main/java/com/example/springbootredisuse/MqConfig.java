package com.example.springbootredisuse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

@Slf4j
@Configuration
public class MqConfig {

    public static final String demoQueue1 = "demo_queue111";
    public static final String demoQueue2 = "demo_queue222";


    public static final String EXCHANGE = "demo_exchange";
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }


    @Bean
    public Queue demoQueue1() {
        return new Queue(demoQueue1, true);
    }
    @Bean
    public Queue demoQueue2() {
        return new Queue(demoQueue2, true);
    }


    public static final String demoProcessKey = "demoProcessKey";


    @Bean
    public Binding bindingQueue1(Queue demoQueue1, DirectExchange exchange) {
        return BindingBuilder.bind(demoQueue1).to(exchange).with(demoProcessKey);
    }
    @Bean
    public Binding bindingQueue2(Queue demoQueue2, DirectExchange exchange) {
        return BindingBuilder.bind(demoQueue2).to(exchange).with(demoProcessKey);
    }



    @Bean
    public SimpleMessageListenerContainer messageListenerContainer1(
            CachingConnectionFactory cachingConnectionFactory) throws UnknownHostException {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cachingConnectionFactory);
        container.setQueueNames(demoQueue1);
        container.setExposeListenerChannel(true);
        container.setPrefetchCount(1);
        container.setConcurrentConsumers(Runtime.getRuntime().availableProcessors());
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener((ChannelAwareMessageListener) (message, channel) -> {
            try {
                log.info("receive message 1 : {}", new String(message.getBody()));
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            } finally {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            }
        });
        return container;
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer2(
            CachingConnectionFactory cachingConnectionFactory) throws UnknownHostException {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cachingConnectionFactory);
        container.setQueueNames(demoQueue2);
        container.setExposeListenerChannel(true);
        container.setPrefetchCount(1);
        container.setConcurrentConsumers(Runtime.getRuntime().availableProcessors());
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener((ChannelAwareMessageListener) (message, channel) -> {
            try {
                log.info("receive message 2 : {}", new String(message.getBody()));
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            } finally {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            }
        });
        return container;
    }

}