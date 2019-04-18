package com.hanson.config;

import com.hanson.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：
 * <p>
 * 使用@Configuration注解
 * 该注解只能标注在类上面,被标注的类是一个Spring应用的配置类,相当于一个applicationContext.xml文件
 * <p>
 * 使用@Bean注解意味着向容器注册一个Bean,类型为返回值类型,id默认是使用方法名作为id.可以使用@Bean注解的属性来自定义id
 * <p>
 * </p>
 */

@Configuration
public class SpringConfiguration {


    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("Spring App");
        person.setAge(20);
        return person;
    }

    @Bean
    public Runnable runnable(){
        return ()->{};
    }

}
