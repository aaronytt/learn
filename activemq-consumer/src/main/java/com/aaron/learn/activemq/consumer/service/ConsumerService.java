package com.aaron.learn.activemq.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @description:
 * @author: aaron
 * @date: 2021/4/21 下午4:31
 */
@Service
public class ConsumerService {
    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(destination = "productor.queue", containerFactory = "queueListenerFactory")
    public void receiveQueueMsg1(String text) {
        System.out.println("receiveQueueMsg1:" + text);
    }

    @JmsListener(destination = "productor.queue", containerFactory = "queueListenerFactory")
    public void receiveQueueMsg2(String text) {
        System.out.println("receiveQueueMsg2:" + text);
    }

    @JmsListener(destination = "productor.queue.reply", containerFactory = "queueListenerFactory")
    public void receiveQueueReply(Message message) throws JMSException {
        System.out.println("receiveQueueReply: " + ((TextMessage)message).getText());
        jmsTemplate.send(message.getJMSReplyTo(), session -> session.createTextMessage("ReplyTo: " + 6666));
    }

    @JmsListener(destination = "productor.topic", containerFactory = "topicListenerFactory")
    @SendTo({"productor.topic.reply"})
    public String receiveTopicMsg1(String text) {
        System.out.println("receiveTopicMsg1:" + text);
        return "receiveTopicMsg1:" + text;
    }

    @JmsListener(destination = "productor.topic", containerFactory = "topicListenerFactory")
    @SendTo("productor.topic.reply")
    public String receiveTopicMsg2(String text) {
        System.out.println("receiveTopicMsg2:" + text);
        return "receiveTopicMsg2:" + text;
    }

}
