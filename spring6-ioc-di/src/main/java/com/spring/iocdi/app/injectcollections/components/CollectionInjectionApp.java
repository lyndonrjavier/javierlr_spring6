package com.spring.iocdi.app.injectcollections.components;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollectionInjectionApp {

	public static void main(String[] args) {
		try(var ctx = new AnnotationConfigApplicationContext()){
			ctx.register(CollectionConfig.class, CollectingBean.class);
	        ctx.refresh();

	        var collectingBean = ctx.getBean(CollectingBean.class);
	        collectingBean.printCollections();
		}

	}

}
