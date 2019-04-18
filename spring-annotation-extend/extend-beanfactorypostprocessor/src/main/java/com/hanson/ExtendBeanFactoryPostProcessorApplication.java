package com.hanson;

import com.hanson.config.ExtendBeanFactoryPostProcessorConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtendBeanFactoryPostProcessorApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtendBeanFactoryPostProcessorConfiguration.class);

    }
}
