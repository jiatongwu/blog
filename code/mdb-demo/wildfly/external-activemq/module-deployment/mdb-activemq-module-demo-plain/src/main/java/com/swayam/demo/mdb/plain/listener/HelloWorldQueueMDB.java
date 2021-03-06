package com.swayam.demo.mdb.plain.listener;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(name = "HelloWorldQueueMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "HELLOWORLDMDBQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class HelloWorldQueueMDB implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldQueueMDB.class);

	@Override
	public void onMessage(Message message) {

		if (!(message instanceof TextMessage)) {
			throw new UnsupportedOperationException("Expecting a " + TextMessage.class);
		}

		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				LOGGER.info("Text message received: {}", textMessage.getText());
			} catch (JMSException e) {
				LOGGER.error("exception reading messsage", e);
			}
		}

	}

}
