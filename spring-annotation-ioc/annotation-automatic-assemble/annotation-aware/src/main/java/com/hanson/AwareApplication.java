package com.hanson;

import com.hanson.config.AwareConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AwareApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfiguration.class);

        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);

        context.close();
    }
}
