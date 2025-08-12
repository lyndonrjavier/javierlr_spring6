package com.spring.iocdi.app.spel.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class InjectSimpleSpEL {

	@Value("#{injectSimple.name.toUpperCase()}")
	private String name;

	@Value("#{injectSimple.age + 1}")
	private int age;

	@Value("#{injectSimple.height}")
	private float height;

	@Value("#{injectSimple.developer}")
	private boolean developer;

	@Value("#{injectSimple.ageInSeconds}")
	private Long ageInSeconds;

	public static void main(String... args) {
		
		try(var ctx = new AnnotationConfigApplicationContext()){
			
			ctx.register(InjectSimple.class, InjectSimpleSpEL.class);
			ctx.refresh();

			InjectSimpleSpEL simple = (InjectSimpleSpEL) ctx.getBean("injectSimpleSpEL");
			System.out.println(simple);
		}
		
	}

	@Override
	public String toString() {
		return "InjectSimpleSpEL [name=" + name + ", age=" + age + ", height=" + height + ", developer=" + developer
				+ ", ageInSeconds=" + ageInSeconds + "]";
	}
	
	

}
