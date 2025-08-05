package com.spring.hello.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.java.hello.app.impl.MessageProviderImpl;
import com.java.hello.app.impl.MessageRendererImpl;
import com.java.hello.app.interfaces.MessageProvider;
import com.java.hello.app.interfaces.MessageRenderer;

@Configuration
public class HelloWorldSpringConfiguration {
	
	@Bean // equivalent to <bean id="provider" class=".."/>
    MessageProvider provider() {
        return new MessageProviderImpl();
    }

	@Bean // equivalent to <bean id="renderer" class=".."/>
    MessageRenderer renderer(){
        MessageRenderer renderer = new MessageRendererImpl();
        renderer.setMessageProvider(provider());
        return renderer;
    }

}
