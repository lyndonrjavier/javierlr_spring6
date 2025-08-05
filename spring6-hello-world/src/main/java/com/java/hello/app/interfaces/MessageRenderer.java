package com.java.hello.app.interfaces;

public interface MessageRenderer {
	void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
