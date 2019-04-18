package com.hanson.bean;

import org.springframework.beans.factory.annotation.Value;

public class ProperySourceBean {

    @Value("${app.name}")
    private String appName;


    @Override
    public String toString() {
        return "ProperySourceBean{" +
                "appName='" + appName + '\'' +
                '}';
    }
}
