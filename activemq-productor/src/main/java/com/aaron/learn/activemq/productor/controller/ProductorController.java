package com.aaron.learn.activemq.productor.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;

/**
 * @description:
 * @author: aaron
 * @date: 2021/4/21 下午4:12
 */
@RestController
@RequestMapping("procductor")
public class ProductorController {

    @Autowired
    JmsMessagingTemplate jmsTemplate;

    @PostMapping("queue")
    public String queue(final String msg){
        Destination queue = new ActiveMQQueue("productor.queue");
//        jmsTemplate.convertAndSend(queue, msg);
        jmsTemplate.convertAndSend(queue, msg);
        return "productor.queue send ok";
    }

    @PostMapping("topic")
    public String topic(final String msg){
        Destination topic = new ActiveMQTopic("productor.topic");
        jmsTemplate.convertAndSend(topic, msg);
        return "productor.topic send ok";
    }

}
