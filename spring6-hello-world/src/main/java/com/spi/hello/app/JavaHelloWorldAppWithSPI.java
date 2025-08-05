package com.spi.hello.app;

import java.util.ServiceLoader;

import com.java.hello.app.interfaces.MessageRenderer;
import com.java.hello.app.interfaces.MessageProvider;

/**
 * With service provider interface (SPI) we can run the implementation of provider and renderer.
 * Required
 * 		- META-INF/services folder in src/main/resources, folder should have flat files.
 * 		- Flat file filename = fully qualified name of interface.
 * 		- Flat file content = fully qualified name of interface implementation.
 */
public class JavaHelloWorldAppWithSPI {

	public static void main(String[] args) {
        ServiceLoader<MessageRenderer> slr = ServiceLoader.load(MessageRenderer.class);
        ServiceLoader<MessageProvider> slp = ServiceLoader.load(MessageProvider.class);

         MessageRenderer mr = slr.findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Service of type 'MessageRenderer' was not found!"));
         MessageProvider mp = slp.findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Service of type 'MessageProvider' was not found!"));

        mr.setMessageProvider(mp);
        mr.render();
	}

}
