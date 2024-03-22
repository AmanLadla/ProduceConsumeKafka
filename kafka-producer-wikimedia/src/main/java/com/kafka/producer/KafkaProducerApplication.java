package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.producer.service.ChangesProducerService;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {
	
	@Autowired
	private ChangesProducerService changesProducerService;
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		changesProducerService.sendMessage();
	}

}
