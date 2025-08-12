package com.spring.iocdi.app.beannaming;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanNamingDemo {
	private static Logger logger = LoggerFactory.getLogger(BeanNamingDemo.class);
	
	public static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(BeanNamingCfg.class)) {
			Arrays.stream(ctx.getBeanDefinitionNames()).forEach(beanName -> logger.debug(beanName));
			
			var beans = ctx.getBeansOfType(SimpleBean.class);
			beans.entrySet().forEach(b -> System.out.println(b.getKey()));
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}
