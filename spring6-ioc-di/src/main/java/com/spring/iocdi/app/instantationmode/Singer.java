package com.spring.iocdi.app.instantationmode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("nonSingleton")
@Scope(scopeName = "prototype")
public class Singer {

    @SuppressWarnings("unused")
	private String name = "unknown";

    public Singer(@Value("John Mayer") String name) {
        this.name = name;
    }
}