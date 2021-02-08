package com.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	private KafkaTemplate<String, String> strinKafkaTemplate;
	
	public void sendMessage(String message) {
		System.out.println("TestService -- sendMessage()");
		strinKafkaTemplate.send("myjlctopic", message);
	}
}
