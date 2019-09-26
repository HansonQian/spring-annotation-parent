package com.hanson.bean;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 基于JSR250规范注解指定初始化和销毁方法
 */
public class Pear {

    private String color;

    public Pear() {
        System.out.println("####JSR250规范 Pear constructor is called ...");
    }

    public Pear(String color) {
        this.color = color;
    }


    @PostConstruct
    public void init() {
        System.out.println("####JSR250规范 Pear init is called . . .");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("####JSR250规范 Pear destroy is called . . .");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("####JSR250规范 Pear attribute assignment . . .");
        this.color = color;
    }
}
