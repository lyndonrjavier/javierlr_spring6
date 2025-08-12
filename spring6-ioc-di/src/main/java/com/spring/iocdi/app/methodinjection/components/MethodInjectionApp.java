package com.spring.iocdi.app.methodinjection.components;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

public class MethodInjectionApp {

	public static void main(String[] args) {
		try(var ctx = new AnnotationConfigApplicationContext(LookupConfig.class)){			

	        var abstractLockOpener = ctx.getBean("abstractLockOpener", LockOpener.class);
	        var standardLockOpener = ctx.getBean("standardLockOpener", LockOpener.class);

	        displayInfo("abstractLockOpener", abstractLockOpener);
	        displayInfo("standardLockOpener", standardLockOpener);
		}
	}
	
	public static void displayInfo(String beanName, LockOpener lockOpener) {
        KeyHelper keyHelperOne = lockOpener.getMyKeyOpener();
        KeyHelper keyHelperTwo = lockOpener.getMyKeyOpener();

        System.out.println("[" + beanName + "]: KeyHelper Instances the Same?  " + (keyHelperOne == keyHelperTwo));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int x = 0; x < 100_000; x++) {
            KeyHelper keyHelper = lockOpener.getMyKeyOpener();
            keyHelper.open();
        }
        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
