package com.spring.iocdi.app.autowiring.pickle;

import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class PickleDemo {
	private static Logger logger = LoggerFactory.getLogger(PickleDemo.class);

	public static void main(String... args) {
        try (var ctx = new AnnotationConfigApplicationContext(AutowiringCfg.class)) {
			var target = ctx.getBean(TrickyTarget.class);
			logger.info("target: Created target? {}" , target != null);
			logger.info("target: Injected bar? {}" , target.bar != null);
			logger.info("target: Injected fooOne? {}" , target.fooOne != null ? target.fooOne.toString(): "");
			logger.info("target: Injected fooTwo? {}" , target.fooTwo != null ? target.fooTwo.toString() : "");
		} catch (BeansException e) {
			e.printStackTrace();
		}

	}

}

interface Foo {
	// empty interface, used as a marker interface
}

class FooImplOne implements Foo {
	String id = "one:" + UUID.randomUUID().toString().replace("-", "").substring(0, 8);

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).toString();
	}
}

class FooImplTwo implements Foo {
	String id = "two:" + UUID.randomUUID().toString().replace("-", "").substring(0, 8);

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).toString();
	}
}

class Bar {
}

@Configuration
@ComponentScan
class AutowiringCfg {

	@Bean
	public Foo fooImplOne() {
		return new FooImplOne();
	}

	@Bean
	public Foo fooImplTwo() {
		return new FooImplTwo();
	}

	@Bean
	public Bar bar() {
		return new Bar();
	}

	@Bean
	public TrickyTarget trickyTarget() {
		return new TrickyTarget();
	}
}


class TrickyTarget {
    private static Logger logger = LoggerFactory.getLogger(TrickyTarget.class);
    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    public TrickyTarget() {
        logger.info(" --> TrickyTarget() called");
    }

    public TrickyTarget( Foo foo) {
        this.fooOne = foo;
        logger.info(" --> TrickyTarget(Foo) called");
    }

    public TrickyTarget(Foo foo, Bar bar) {
        this.fooOne = foo;
        this.bar = bar;
        logger.info(" --> TrickyTarget(Foo, Bar) called");
    }

    // comment @Qualifier annotation to cause NoUniqueBeanDefinitionException being thrown at runtime
    @Autowired
    @Qualifier("fooImplOne")
    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        logger.info(" --> Property fooOne set");
    }

    // comment @Qualifier annotation to cause NoUniqueBeanDefinitionException being thrown at runtime
    // and make sure for @Primary in FooImpl to be commented as well
    @Autowired
    @Qualifier("fooImplTwo")
    public void setFooTwo(Foo foo) {
        this.fooTwo = foo;
        logger.info(" --> Property fooTwo set");
    }

    @Autowired
    public void setBar(Bar bar) {
        this.bar = bar;
        logger.info(" --> Property bar set");
    }
}
