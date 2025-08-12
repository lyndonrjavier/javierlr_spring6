package com.spring.iocdi.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("injectSimple")
public class InjectValueApp {

    @Value("John Mayer")
    private String name;
    @Value("40")
    private int age;
    @Value("1.92")
    private float height;
    @Value("false")
    private boolean developer;
    @Value("1241401112")
    private Long ageInSeconds;

    public static void main(String... args) {
    	try(var ctx = new AnnotationConfigApplicationContext();){
    		ctx.register(InjectValueApp.class);
            ctx.refresh();

            InjectValueApp app = (InjectValueApp) ctx.getBean("injectSimple");
            System.out.println(app);
    	} 
    }

    public String toString() {
        return "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Age in Seconds: " + ageInSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is Developer?: " + developer;
    }

}
