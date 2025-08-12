package com.spring.iocdi.app.ci.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.iocdi.app.interfaces.MessageProvider;
import com.spring.iocdi.app.interfaces.MessageRenderer;

@Component("renderer")
class MessageRendererImpl implements MessageRenderer {
	private static final Logger logger = LoggerFactory.getLogger(MessageRendererImpl.class);
	private MessageProvider messageProvider;
	
	/**
	 * No need to add @Autowired as Spring will automatically Inject the messageProvider since there is only one constructor in this class.
	 * @param messageProvider
	 */
	MessageRendererImpl(MessageProvider messageProvider) {
		logger.info(" --> Constructor called via Constructor Injection.");
		this.messageProvider = messageProvider;
		//System.out.println(" --> MessageRendererImpl: constructor called");
	}

	@Override
	public void render() {
		if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + MessageRendererImpl.class.getName());
        }
		logger.info(messageProvider.getMessage());
		//System.out.println(messageProvider.getMessage());

	}

	public void setMessageProvider(MessageProvider provider) {
		logger.info(" --> MessageRendererImpl: setting the provider");
        this.messageProvider = provider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}

}
