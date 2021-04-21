package com.aaron.learn.activemq.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * @description:
 * @author: aaron
 * @date: 2021/4/21 下午4:10
 */
@Configuration
public class MQConfig {
    @Bean("queueListenerFactory")
    public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory queueConnectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(queueConnectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }

    @Bean("topicListenerFactory")
    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory topicConnectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(topicConnectionFactory);	//设置为发布订阅方式, 默认情况下使用的生产消费者方式
        factory.setPubSubDomain(true);
        return factory;
    }
}
