package com.spring.hello.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.hello.app.interfaces.MessageRenderer;

public class SpringHelloWorldAppXmlBased {

	public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");

        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
	}

}
