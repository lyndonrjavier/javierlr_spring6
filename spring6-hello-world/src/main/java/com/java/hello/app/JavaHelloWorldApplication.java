package com.java.hello.app;

import com.java.hello.app.impl.MessageProviderImpl;
import com.java.hello.app.impl.MessageRendererImpl;
import com.java.hello.app.interfaces.MessageRenderer;
import com.java.hello.app.interfaces.MessageProvider;

public class JavaHelloWorldApplication {

	public static void main(String[] args) {
		MessageRenderer mr = new MessageRendererImpl();
        MessageProvider mp = new MessageProviderImpl();
        mr.setMessageProvider(mp);
        mr.render();
	}

}
