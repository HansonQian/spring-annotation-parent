package com.hanson;

import com.hanson.config.ExtendBeanDefinitionRegistryPostProcessorConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtendBeanDefinitionRegistryPostProcessorApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtendBeanDefinitionRegistryPostProcessorConfiguration.class);

        context.close();
    }
}
