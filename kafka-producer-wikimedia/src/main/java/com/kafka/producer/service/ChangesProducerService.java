package com.kafka.producer.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;

@Service
public class ChangesProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

//	private final static Logger logger = LoggerFactory.getLogger(ChangesProducerService.class);

	public void sendMessage() throws InterruptedException {

		String topic = "wikiMedia_recent_change";
		
		String url = "https://stream.wikimedia.org/v2/stream/recentchange"; 
				
		BackgroundEventHandler eventHandler = new WikiMediaChangesHandlerService(kafkaTemplate, topic);

		BackgroundEventSource backgroundEventSource = new BackgroundEventSource.Builder(eventHandler,
				new EventSource.Builder(URI.create(url))).build();
		
		backgroundEventSource.start();
		
		TimeUnit.MINUTES.sleep(10);

	}

}
