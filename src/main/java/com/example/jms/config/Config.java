package com.example.jms.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class Config {
	
	@Value("${activemq.broker-url}")
	private String brokerURL;
	
	/**
	 * 1. We need a Queue
	 */
	@Bean	
	public Queue queue() {
		return new ActiveMQQueue("first.queue");
	}
	
	/**
	 * 2. We need to create a ActiveMq factory with broker URL
	 */
	@Bean
	public ActiveMQConnectionFactory activeMqConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerURL);
		return factory;
	}
	
	/**
	 * 3. We need to create a JmsTemplate with ActiveMqConnectionFactory in step 2
	 */
	
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMqConnectionFactory());
	}

}
