package com.spring.iocdi.app.si.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.iocdi.app.interfaces.MessageProvider;
import com.spring.iocdi.app.interfaces.MessageRenderer;

@Component("renderer")
class MessageRendererImpl implements MessageRenderer {
	private static final Logger logger = LoggerFactory.getLogger(MessageRendererImpl.class);
	private MessageProvider messageProvider;
	
	MessageRendererImpl() {
		logger.info(" --> MessageRendererImpl: constructor called");
	}

	@Override
	public void render() {
		if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + MessageRendererImpl.class.getName());
        }
		logger.info(messageProvider.getMessage());
	}

	@Autowired
	public void setMessageProvider(MessageProvider provider) {
		logger.info(" --> Setter called via Setter Injection.");
        this.messageProvider = provider;

	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}

}
