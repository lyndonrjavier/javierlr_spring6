package com.spring.iocdi.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.iocdi.app.config.HelloWorldSpringConfiguration;
import com.spring.iocdi.app.interfaces.MessageRenderer;

public class SpringIocDiApplication {

	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldSpringConfiguration.class)){		
			MessageRenderer renderer = ctx.getBean("renderer", MessageRenderer.class);
			renderer.render();
		}		
	}

}
