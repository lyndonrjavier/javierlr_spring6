package com.spring.iocdi.app.ci.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.iocdi.app.interfaces.MessageProvider;

@Component("provider")
class MessageProviderImpl implements MessageProvider {
	private static final Logger logger = LoggerFactory.getLogger(MessageProviderImpl.class);

	@Override
	public String getMessage() {
		logger.info("MessageProvider getMessage() method called");
		return "Hello World!";
	}

}
