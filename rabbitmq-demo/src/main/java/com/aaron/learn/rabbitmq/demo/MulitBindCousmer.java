package com.aaron.learn.rabbitmq.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 一个队列 绑定 多个路由
 * @author: aaron
 * @date: 2021/6/6 下午10:11
 */
public class MulitBindCousmer {

    private final static String EXCHANGE_NAME = "direct_log";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
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

//            //声明一个队列
//            String queueName = "myinfo";
//            channel.queueDeclare(queueName, false, false, false, null);

            //声明一个随机队列
            String queueName = channel.queueDeclare().getQueue();

            String[] routingKeys = {"info", "error", "warn" };

            for (String routingkey : routingKeys) {
                //绑定
                channel.queueBind(queueName, EXCHANGE_NAME, routingkey);
            }

//            //绑定
//            String rountKey = "info";
//            channel.queueBind(queueName, EXCHANGE_NAME, rountKey);
            System.out.println("waiting for message ......");

            //声明一个消费者
            final Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body
                ) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Received [" + envelope.getRoutingKey() + "] : " + message);
                    super.handleDelivery(consumerTag, envelope, properties, body);
                }
            };

            //消费
            channel.basicConsume(queueName, true, consumer);

            //try-with 会关闭连接，所以会等待一会
            Thread.sleep(100000000);

//            //路由键
//            String[] routingKeys = {"info", "error", "warn" };
//
//            for (int i = 0; i < routingKeys.length; i++) {
//                String msg = "rabbitmq msg: " + LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
//                //发送消息
//                channel.basicPublish(EXCHANGE_NAME, routingKeys[i], null, msg.getBytes());
//            }
        }

    }

}
