package com.spring.iocdi.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.iocdi.app.fi.components.Inspiration;
import com.spring.iocdi.app.fi.components.Singer;

public class SingerFieldInjectionApp {

	public static void main(String[] args) {
		try(var ctx = new AnnotationConfigApplicationContext()){
			ctx.register(Singer.class, Inspiration.class);
			ctx.refresh();
			
			Singer singer = ctx.getBean(Singer.class);
			singer.sing();
		}	
	}

}
