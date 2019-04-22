package amq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Producer {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		FanoutExchange topicExchange = context.getBean(FanoutExchange.class);
		System.out.println("=====>" + topicExchange.getName());
		amqpTemplate.convertAndSend(topicExchange.getName(),null,"Hello World");
		System.out.println("Sent: Hello World");
	}

}
