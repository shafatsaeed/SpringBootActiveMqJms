package com.example.jms.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jms.dto.MessageDTO;

@RestController
public class ProducerController {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	Queue queue;
	
	@PostMapping("/pushMsg")
	public ResponseEntity<Object> pushMessage(@RequestBody MessageDTO messageDto){
		if(messageDto.getMessage().equals("")) {
			return new ResponseEntity<Object>("invalid message",HttpStatus.NOT_FOUND);
		}
		jmsTemplate.convertAndSend(queue, messageDto.getMessage());
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
