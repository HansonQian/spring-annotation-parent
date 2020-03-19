package com.hanson;

import com.hanson.bean.PropertySourceBean;
import com.hanson.config.PropertySourceConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PropertySourceConfiguration.class);
        context.refresh();
        PropertySourceBean bean = context.getBean(PropertySourceBean.class);
        System.out.println(bean);
        context.close();
    }
}
