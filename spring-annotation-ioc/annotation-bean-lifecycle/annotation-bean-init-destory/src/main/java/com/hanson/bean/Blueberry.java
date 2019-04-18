package com.hanson.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 实现Spring提供的接口 实现InitializingBean和DisposableBean接口
 */
public class Blueberry implements InitializingBean, DisposableBean {
    private String color;

    public Blueberry() {
        System.out.println("****Implement interface **** Blueberry constructor is called ...");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("****Implement interface **** Blueberry attribute assignment...");
        this.color = color;
    }

    public Blueberry(String color) {
        this.color = color;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("****Implement interface **** Blueberry destroy is called ...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("****Implement interface **** Blueberry afterPropertiesSet is called ...");
    }
}
