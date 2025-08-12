package com.spring.iocdi.app.methodinjection.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("keyHelper")
@Scope("prototype")
class KeyHelper {
     public void open(){
     }
}