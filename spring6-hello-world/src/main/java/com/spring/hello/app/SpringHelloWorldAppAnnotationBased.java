package com.spring.hello.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.hello.app.interfaces.MessageRenderer;
import com.spring.hello.app.config.HelloWorldSpringConfiguration;

public class SpringHelloWorldAppAnnotationBased {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldSpringConfiguration.class);
		
		MessageRenderer renderer = ctx.getBean("renderer", MessageRenderer.class);
		renderer.render();
		
	}

}
