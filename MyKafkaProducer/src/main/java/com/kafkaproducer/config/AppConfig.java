package com.kafkaproducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@SpringBootApplication
public class AppConfig {
	//@Value(value = "${kafka.bootstrapAddress}")
	//private String bootstrapAddress; 
	
	@Bean
	public ProducerFactory<String, String> stringProducerFactory(){
		Map<String, Object> props = new HashMap<String, Object>();
			
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		return new DefaultKafkaProducerFactory<String, String>(props);
	}
	
	@Bean(name = "stringKafkaTemplate")
	public KafkaTemplate<String, String> stringKafkaTemplate(){
		return new KafkaTemplate<String, String>(stringProducerFactory());
	}

}
