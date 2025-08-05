package com.java.hello.app.impl;

import com.java.hello.app.interfaces.MessageProvider;

public class MessageProviderImpl implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello World!";
	}

}
