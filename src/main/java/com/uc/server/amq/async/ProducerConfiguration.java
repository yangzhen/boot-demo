package com.uc.server.amq.async;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ProducerConfiguration {

    protected final String helloWorldQueueName = "hello.world.queue";

    public RabbitTemplate rabbitTemplate() {

        RabbitTemplate template = new RabbitTemplate()
    }

    public ConnectionFactory
}
