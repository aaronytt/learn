package com.aaron.learn.activemq.consumer.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: aaron
 * @date: 2021/4/21 下午4:31
 */
@Service
public class ConsumerService {
    @JmsListener(destination = "productor.queue", containerFactory = "queueListenerFactory")
    public void receiveQueueMsg1(String text) {
        System.out.println("receiveQueueMsg1:"+text);
    }

    @JmsListener(destination = "productor.queue", containerFactory = "queueListenerFactory")
    public void receiveQueueMsg2(String text) {
        System.out.println("receiveQueueMsg2:"+text);
    }

    @JmsListener(destination = "productor.topic", containerFactory = "topicListenerFactory")
    public void receiveTopicMsg1(String text) {
        System.out.println("receiveTopicMsg1:"+text);
    }

    @JmsListener(destination = "productor.topic", containerFactory = "topicListenerFactory")
    public void receiveTopicMsg2(String text) {
        System.out.println("receiveTopicMsg2:"+text);
    }

}
