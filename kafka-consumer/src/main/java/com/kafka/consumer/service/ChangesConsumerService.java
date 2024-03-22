package com.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ChangesConsumerService {
	
	private final static Logger logger = LoggerFactory.getLogger(ChangesConsumerService.class);
	
	@KafkaListener(topics = "wikiMedia_recent_change", groupId = "myGroup")
	public void onMessage(String message) {
		
		logger.info(String.format("Recieved message -> %s", message));
		
	}

}
