package com.spring.iocdi.app.autowiring.constructor;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class ConstructorAutowiringDemo {

	private static Logger logger = LoggerFactory.getLogger(ConstructorAutowiringDemo.class);

    public static void main(String... args) {
        try (var ctx = new AnnotationConfigApplicationContext(AutowiringCfg.class)) {
			var target = ctx.getBean(Target.class);
			logger.info("Created target? {}" , target != null);
			logger.info("Injected bar? {}" , target.bar != null);
			logger.info("Injected fooOne? {}" , target.fooOne != null ? target.fooOne.id: "");
			logger.info("Injected fooTwo? {}" , target.fooTwo != null ? target.fooTwo.id : "");
		} catch (BeansException e) {
			e.printStackTrace();
		}
    }
}

@Configuration
@ComponentScan
class AutowiringCfg {}

@Component
@Lazy
class Target {

    private static Logger logger = LoggerFactory.getLogger(Target.class);
    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    /**
     * Default constructor of Spring for target bean
     */
    public Target() {
        logger.info(" --> Target() called");
    }
    
    /**
     * If this is only constructor of target bean, fooOne will point to foo bean.
     * 
     * @param foo
     */
    public Target(Foo foo) {
        this.fooOne = foo;
        logger.info(" --> Target(Foo) called");
    }
    /**
     * If this is only constructor of target bean, fooTwo will point to foo bean and bar will point to bar bean.
     * 
     * @param foo
     * @param bar
     */
    public Target(Foo foo, Bar bar) {
        this.fooTwo = foo;
        this.bar = bar;
        logger.info(" --> Target(Foo, Bar) called");
    }

}

@Component
class Foo {
    String id = UUID.randomUUID().toString().replace("-","").substring(0,8);
}

@Component
class Bar {}