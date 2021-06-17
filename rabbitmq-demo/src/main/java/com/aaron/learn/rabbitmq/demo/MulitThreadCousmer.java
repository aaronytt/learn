package com.aaron.learn.rabbitmq.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 一个连接可以创建多个信道，  一个队列可以有多个消费者
 * @author: aaron
 * @date: 2021/6/6 下午10:19
 */
public class MulitThreadCousmer {

    private final static String EXCHANGE_NAME = "direct_log";

    private static class ConsumerWorker implements Runnable {

        final Connection connection;
        final String queueName;

        public ConsumerWorker(Connection connection, String queueName){
            this.connection = connection;
            this.queueName = queueName;
        }

        @Override
        public void run() {

            try {
                final Channel channel = connection.createChannel();
                channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

                String consumerQueueName = this.queueName;
                //消费者的名字(线程)
                final String consumerName;

                //声明一个队列，如果队列已经纯在，就不重复创建
                if(consumerQueueName == null || consumerQueueName.equals("")){
                    //一个连接可以创建多个信道
                    consumerQueueName = channel.queueDeclare().getQueue();
                    consumerName = Thread.currentThread().getName() + "-all";
                } else {
                    // 一个队列可以有多个消费者
                    channel.queueDeclare(consumerQueueName, false, false, false, null);
                    consumerName = Thread.currentThread().getName();
                }

                String[] routingKeys = {"info", "error", "warn" };
                for (String routingkey : routingKeys) {
                    //绑定
                    channel.queueBind(consumerQueueName, EXCHANGE_NAME, routingkey);
                }

                System.out.println("[" + consumerName + "]: " + "Waiting for message ..." );

                final Consumer consumer = new DefaultConsumer(channel){
                    @Override
                    public void handleDelivery(String consumerTag,
                                               Envelope envelope,
                                               AMQP.BasicProperties properties,
                                               byte[] body
                    ) throws IOException {
                        String message = new String(body, "UTF-8");
                        System.out.println("[" + consumerName + "] Received [" + envelope.getRoutingKey() + "] : " + message);
                        super.handleDelivery(consumerTag, envelope, properties, body);
                    }
                };

                //消费
                channel.basicConsume(queueName, true, consumer);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        Connection connection = connectionFactory.newConnection();

        for (int i = 0; i < 3; i++) {
            new Thread(new ConsumerWorker(connection, "")).start();
        }

        String queueName = "log";
        for (int i = 0; i < 3; i++) {
            new Thread(new ConsumerWorker(connection, queueName)).start();
        }
        
    }


}
