package com.example.springbootredisuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;

/**
 * @author unisound
 * Redis 配置类
 */

@Configuration
public class RedisConfig {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @PostConstruct
    public void init() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
    }

//    @Bean
//    public Queue queue() throws UnknownHostException {
//        return new Queue("myqueue_" + InetAddress.getLocalHost().getHostName(), true);
//    }
//
//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer(CachingConnectionFactory cachingConnectionFactory) throws UnknownHostException {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cachingConnectionFactory);
//        // 监听队列的名称
//        container.setQueueNames("myqueue_" + InetAddress.getLocalHost().getHostName());
//        container.setExposeListenerChannel(true);
//        // 设置每个消费者获取的最大消息数量
//        container.setPrefetchCount(1);
//        // 消费者的个数
//        container.setConcurrentConsumers(1);
//        // 设置确认模式为手工确认
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        container.setMessageListener(new PackMsgReceiver());
//        return container;
//    }
//
//    @Bean
//    public ListOperations<Object, Object> valueOperations(RedisTemplate<Object, Object> redisTemplate) {
//        return redisTemplate.opsForList();
//    }
//
//    @Bean
//    public HashOperations<Object, Object, Object> hashOperations(RedisTemplate<Object, Object> redisTemplate) {
//        return redisTemplate.opsForHash();
//    }
//
//
//
//    private static class PackMsgReceiver implements ChannelAwareMessageListener {
//        @Override
//        public void onMessage(Message message, Channel channel) throws Exception {
//            byte[] body = message.getBody();
//            System.out.println("接收到消息:" + new String(body));
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);//确认消息消费成功
//        }
//    }

}