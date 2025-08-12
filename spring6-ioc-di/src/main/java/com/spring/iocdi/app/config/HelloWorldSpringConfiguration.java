package com.spring.iocdi.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan(basePackages = {"com.spring.iocdi.app.components"})
public class HelloWorldSpringConfiguration {

}
