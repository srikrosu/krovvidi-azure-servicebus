package com.krovvidi.cloud.azure.servicebus.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.krovvidi.cloud.azure.servicebus.model.User;

@Component
public class QueueReceiver {

	private static final String QUEUE_NAME = "recycle-queue";

	private final Logger logger = LoggerFactory.getLogger(QueueReceiver.class);

	@JmsListener(destination = QUEUE_NAME, containerFactory = "jmsListenerContainerFactory")
	public void receiveMessage(User user) {
		logger.info("Received message: {}", user.getName());
	}
}
