package com.example.jms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerComponent {
	@JmsListener(destination = "first.queue")
	public void consumeMessages(String message) {
		System.out.println("Consumed message: "+message);
	}
}
