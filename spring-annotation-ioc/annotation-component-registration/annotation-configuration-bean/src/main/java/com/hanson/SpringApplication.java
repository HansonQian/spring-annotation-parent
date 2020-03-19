package com.hanson;

import com.hanson.bean.Person;
import com.hanson.config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class SpringApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        String[] names = applicationContext.getBeanDefinitionNames();

        List<String> strings = Arrays.asList(names);
        strings.forEach(System.out::println);


        applicationContext.close();


        


    }
}
