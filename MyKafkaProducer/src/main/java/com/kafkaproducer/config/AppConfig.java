package com.kafkaproducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.kafkaproducer.enity.Order;

@SpringBootApplication
public class AppConfig {
	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress; 
	
	@Bean
	public ProducerFactory<String, String> stringProducerFactory(){
		Map<String, Object> props = new HashMap<String, Object>();
			
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		return new DefaultKafkaProducerFactory<String, String>(props);
	}
	
	public ProducerFactory<String, Order> orderProducerFactory(){
		Map<String, Object> props = new HashMap<String, Object>();
		
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		return new DefaultKafkaProducerFactory<String, Order>(props);
	}
	
	@Bean(name = "stringKafkaTemplate")
	public KafkaTemplate<String, String> stringKafkaTemplate(){
		return new KafkaTemplate<String, String>(stringProducerFactory());
	}
	
	@Bean(name = "orderKafkaTemplate")
	public KafkaTemplate<String, Order> orderKafkaTemplate(){
		return new KafkaTemplate<String, Order>(orderProducerFactory());
	}
}
