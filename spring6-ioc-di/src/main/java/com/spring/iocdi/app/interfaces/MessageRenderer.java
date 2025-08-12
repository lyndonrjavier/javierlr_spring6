package com.spring.iocdi.app.interfaces;

public interface MessageRenderer {
	void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
