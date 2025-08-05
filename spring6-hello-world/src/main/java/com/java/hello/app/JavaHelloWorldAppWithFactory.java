package com.java.hello.app;

import com.java.hello.app.factory.MessageSupportFactory;
import com.java.hello.app.interfaces.MessageRenderer;
import com.java.hello.app.interfaces.MessageProvider;

public class JavaHelloWorldAppWithFactory {

	public static void main(String[] args) {
		MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer()
				.orElseThrow(() -> new IllegalArgumentException("Service of type 'MessageRenderer' was not found!"));
		MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider()
				.orElseThrow(() -> new IllegalArgumentException("Service of type 'MessageProvider' was not found!"));
		mr.setMessageProvider(mp);
		mr.render();
	}

}
