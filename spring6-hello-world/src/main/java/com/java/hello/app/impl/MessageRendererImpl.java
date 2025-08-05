package com.java.hello.app.impl;

import com.java.hello.app.interfaces.MessageProvider;
import com.java.hello.app.interfaces.MessageRenderer;

public class MessageRendererImpl implements MessageRenderer {
	private MessageProvider messageProvider;
	
	

	public MessageRendererImpl() {
		System.out.println(" --> MessageRendererImpl: constructor called");
	}

	@Override
	public void render() {
		if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + MessageRendererImpl.class.getName());
        }
		System.out.println(messageProvider.getMessage());

	}

	@Override
	public void setMessageProvider(MessageProvider provider) {
		System.out.println(" --> MessageRendererImpl: setting the provider");
        this.messageProvider = provider;

	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}

}
