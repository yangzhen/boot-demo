package com.uc.server.amq.subscribe;

import com.rabbitmq.client.*;
import org.springframework.amqp.core.Queue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ReceiveLogs {

    private static final String EXCHANE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANE_NAME, BuiltinExchangeType.FANOUT);
        String queueName = channel.queueDeclare().getQueue();
        //String queueName = "yxy.1";
        //channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName,EXCHANE_NAME,"");

        System.out.println("[*] waiting for message, to exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("[x] received " + message);
            }
        };

        channel.basicConsume(queueName,true,consumer);
    }
}
