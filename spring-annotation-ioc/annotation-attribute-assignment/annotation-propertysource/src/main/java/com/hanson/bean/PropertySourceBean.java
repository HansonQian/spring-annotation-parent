package com.hanson.bean;

import org.springframework.beans.factory.annotation.Value;

public class PropertySourceBean {
    @Value("${app.name}")
    private String appName;
    @Override
    public String toString() {
        return "PropertySourceBean{" +
                "appName='" + appName + '\'' +
                '}';
    }
}
