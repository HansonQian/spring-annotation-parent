package com.hanson.bean;

import org.springframework.beans.factory.annotation.Value;

public class ValueBean {

    /*
     使用@Value注解进行属性赋值
     1、基本数值
     2、使用SpEL表达式：#{}
     3、使用${}取出配置文件中的值(在运行环境变量里面的值)
     */
    @Value("钱海生")
    private String name;

    @Value("#{27-2}")
    private String age;

    @Override
    public String toString() {
        return "ValueBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
