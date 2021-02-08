package com.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaproducer.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/testMsg")
	public String testMessage() {
		System.out.println("TestController --  testMessage()");
		testService.sendMessage("Hello Guys - This is message1, how kafka is usefull in jms?");
		//testService.sendMessage("Hello Guys - This is message2");
		return "String message sent to Kafka Server";
	}
}
