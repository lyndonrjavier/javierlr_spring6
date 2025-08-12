package com.spring.iocdi.app.ctxnesting.components;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextNextingApp {

	public static void main(String... args) {
		try (var parentCtx = new AnnotationConfigApplicationContext();
				var childCtx = new AnnotationConfigApplicationContext();) {

			parentCtx.register(ParentConfig.class);
			parentCtx.refresh();

			childCtx.register(ChildConfig.class);
			childCtx.setParent(parentCtx);
			childCtx.refresh();

			Song song1 = (Song) childCtx.getBean("song1");
			Song song2 = (Song) childCtx.getBean("song2");
			Song song3 = (Song) childCtx.getBean("song3");
			System.out.println("from parent ctx: " + song1.getTitle());
			System.out.println("from child ctx: " + song2.getTitle());
			System.out.println("from child ctx: " + song3.getTitle());
		}

	}

}
