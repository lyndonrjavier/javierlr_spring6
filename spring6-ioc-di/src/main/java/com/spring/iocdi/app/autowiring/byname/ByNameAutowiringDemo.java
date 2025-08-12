package com.spring.iocdi.app.autowiring.byname;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class ByNameAutowiringDemo {
	private static Logger logger = LoggerFactory.getLogger(ByNameAutowiringDemo.class);
	
	public static void main(String... args) {

		try (var ctx = new AnnotationConfigApplicationContext(AutowireConfig.class)) {
			var anotherTarget = ctx.getBean(AnotherTarget.class);
			logger.info("anotherTarget: Created anotherTarget? {}", anotherTarget != null);
			logger.info("anotherTarget: Injected bar? {}", anotherTarget.bar != null);
			logger.info("anotherTarget: Injected fooOne? {}",
					anotherTarget.fooOne != null ? anotherTarget.fooOne.id : "");
			logger.info("anotherTarget: Injected fooTwo? {}",
					anotherTarget.fooTwo != null ? anotherTarget.fooTwo.id : "");
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}

@Component
@Lazy
class AnotherTarget {

    private static Logger logger = LoggerFactory.getLogger(AnotherTarget.class);
    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    @Autowired
    public void setFooOne(@Qualifier("foo")Foo fooOne) {
        logger.info(" --> AnotherTarget#setFooOne(Foo) called");
        this.fooOne = fooOne;
    }

    @Autowired
    public void setFooTwo(@Qualifier("anotherFoo")Foo fooTwo) {
        logger.info(" --> AnotherTarget#setFooTwo(Foo) called");
        this.fooTwo = fooTwo;
    }

    @Autowired
    public void setBar(Bar bar) {
        logger.info(" --> AnotherTarget#setBar(Bar) called");
        this.bar = bar;
    }
}

@Component
@Lazy
class FieldTarget {

    //private static Logger logger = LoggerFactory.getLogger(FieldTarget.class);

    @Autowired @Qualifier("foo") Foo fooOne;
    @Autowired @Qualifier("anotherFoo") Foo fooTwo;
    @Autowired Bar bar;

}

@Configuration
@ComponentScan
class AutowireConfig {
	@Bean
	Foo anotherFoo() {
		return new Foo();
	}	
}

@Component
class Foo {
    String id = UUID.randomUUID().toString().replace("-","").substring(0,8);
}

@Component
class Bar {}
