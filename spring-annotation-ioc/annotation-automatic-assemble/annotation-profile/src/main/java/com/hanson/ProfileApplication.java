package com.hanson;

import com.hanson.config.ProfileConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class ProfileApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //获取当前运行环境
        ConfigurableEnvironment environment = context.getEnvironment();
        //设置需要设置的环境(也可以通过JVM启动参数设置 -Dspring.profiles.active="prod")
        environment.setActiveProfiles("dev");
        //注册配置
        context.register(ProfileConfiguration.class);

        //启动IOC刷新
        context.refresh();

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        context.close();
    }
}
