package com.spring.iocdi.app.methodinjection.components;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // default package to scan: the same as this class package
class LookupConfig {}

