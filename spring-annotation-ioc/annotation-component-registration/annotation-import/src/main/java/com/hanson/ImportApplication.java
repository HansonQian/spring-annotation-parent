package com.hanson;

import com.hanson.config.ImportConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ImportApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportConfiguration.class);

        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);

        //获取工厂Bean
        Object bean = context.getBean("&blueFactoryBean");
        System.out.println(bean.getClass());
        context.close();
    }
}
