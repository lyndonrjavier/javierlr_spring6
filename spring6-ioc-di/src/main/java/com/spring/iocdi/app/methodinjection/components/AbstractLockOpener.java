package com.spring.iocdi.app.methodinjection.components;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLockOpener")
abstract class AbstractLockOpener implements LockOpener{

	@Lookup("keyHelper")
    @Override
    public abstract KeyHelper getMyKeyOpener() ;

    @Override
    public void openLock() {
        getMyKeyOpener().open();
    }
}
