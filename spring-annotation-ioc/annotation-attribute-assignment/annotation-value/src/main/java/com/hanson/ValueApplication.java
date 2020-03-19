package com.hanson;

import com.hanson.bean.ValueBean;
import com.hanson.config.ValueConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ValueApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ValueConfiguration.class);
        ValueBean valueBean = context.getBean(ValueBean.class);
        System.out.println(valueBean);
        context.close();
    }
}
