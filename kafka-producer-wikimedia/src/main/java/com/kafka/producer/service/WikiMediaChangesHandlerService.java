package com.kafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;

public class WikiMediaChangesHandlerService implements BackgroundEventHandler{
	
	private KafkaTemplate<String, String> kafkaTemplate;

	private String topic;
	
	private final static Logger logger = LoggerFactory.getLogger(WikiMediaChangesHandlerService.class);
	
	public WikiMediaChangesHandlerService(KafkaTemplate<String, String> kafkaTemplate, String topic) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		
//		logger.info(String.format("Message Recieved from wikiMedia ==> %s", messageEvent.getData()));
		
		kafkaTemplate.send(topic, messageEvent.getData());
	
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
