package com.hanson.bean;

/**
 * 使用@Bean注解属性指定Bean的初始化和销毁方法
 */
public class Apple {

    private String color;

    public Apple() {
        System.out.println("****Apple**** constructor is called ...");
    }

    public Apple(String color) {
        this.color = color;
    }

    public void init() {
        System.out.println("****Apple**** init is called ...");
    }


    public void destroy() {
        System.out.println("****Apple**** destroy is called ...");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("****Apple**** attribute assignment . . . .");
        this.color = color;
    }
}
