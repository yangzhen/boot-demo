package amq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Consumer {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		Queue queue = context.getBean(Queue.class);
		System.out.println("=====》" + queue.getName());
		Message message = amqpTemplate.receive(queue.getName());
		while(message != null) {
			System.out.println("Received: " + message.toString());
			message = amqpTemplate.receive(queue.getName());
			//System.out.println("Received: " + amqpTemplate.receiveAndConvert());
		}

	}

}
