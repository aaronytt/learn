package com.aaron.learn.activemq.productor.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
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
    JmsTemplate jmsTemplate;
    @Autowired
    Response response;

    @PostMapping("queue")
    public String queue(final String msg){
        Destination queue = new ActiveMQQueue("productor.queue");
//        jmsTemplate.convertAndSend(queue, msg);
        jmsTemplate.send(queue, session -> {
            Message message = session.createTextMessage(msg);
            Destination destination = session.createTemporaryQueue();
            MessageConsumer messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(response);
            message.setJMSReplyTo(destination);
            System.out.println();
            return message;
        });
        return "productor.queue send ok";
    }

    @PostMapping("topic")
    public String topic(final String msg){
        Destination topic = new ActiveMQTopic("productor.topic");
        jmsTemplate.convertAndSend(topic, msg);
        return "productor.topic send ok";
    }

    @PostMapping("reply")
    public String reply(final String msg){
        Destination queue = new ActiveMQQueue("productor.queue.reply");
//        jmsTemplate.convertAndSend(queue, msg);
        jmsTemplate.send(queue, session -> {
            Message message = session.createTextMessage(msg);
            Destination destination = session.createTemporaryQueue();
            MessageConsumer messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(response);
            message.setJMSReplyTo(destination);

            message.setJMSCorrelationID(System.currentTimeMillis()+ "");

            return message;
        });
        return "productor.queue.reply send ok";
    }

    @JmsListener(destination = "productor.topic.reply", containerFactory = "topicListenerFactory")
    public void receiveTopicMsg(String text) {
        System.out.println("receiveTopicMsg:" + text);
    }

}
