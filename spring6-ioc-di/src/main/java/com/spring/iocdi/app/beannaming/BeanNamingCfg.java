package com.spring.iocdi.app.beannaming;

import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(nameGenerator = SimpleBeanNameGenerator.class)
public class BeanNamingCfg {

    @Bean
    SimpleBean anotherSimpleBean(){
        return new SimpleBean();
    }

}

class SimpleBeanNameGenerator extends AnnotationBeanNameGenerator {
    @Override
    protected String buildDefaultBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        var beanName = definition.getBeanClassName().substring(definition.getBeanClassName().lastIndexOf(".") + 1).toLowerCase(Locale.ROOT);
        var uid = UUID.randomUUID().toString().replace("-","").substring(0,8);
        return beanName + "-" + uid;
    }
}