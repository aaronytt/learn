package com.aaron.learn.rabbitmq.demo;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: aaron
 * @date: 2021/6/3 下午3:46
 */
public class DirectProductor {

    private final static String EXCHANGE_NAME = "direct_log";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        try(
                //创建连接
                Connection connection = connectionFactory.newConnection();
                //创建信道
                Channel channel = connection.createChannel()
        ){
            //绑定交换机
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

            //路由键
            String[] routingKeys = {"info", "error", "warn" };

            for (int i = 0; i < routingKeys.length; i++) {
                String msg = "rabbitmq msg " + routingKeys[i] + ": " + LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
                //发送消息
                channel.basicPublish(EXCHANGE_NAME, routingKeys[i], null, msg.getBytes());
            }
        }
    }

}
