package com.hanson;

import com.hanson.config.ComponentScanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ComponentScanApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        //遍历全部的Bean
        Arrays.asList(beanDefinitionNames).forEach(System.out::println);

        applicationContext.close();
    }
}
