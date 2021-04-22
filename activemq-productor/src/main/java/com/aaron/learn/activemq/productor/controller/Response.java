package com.aaron.learn.activemq.productor.controller;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @description:
 * @author: aaron
 * @date: 2021/4/22 上午11:45
 */
@Component
public class Response implements MessageListener {
    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        String replyText = ((TextMessage)message).getText();
        System.out.println("Response: " + replyText);
    }
}
