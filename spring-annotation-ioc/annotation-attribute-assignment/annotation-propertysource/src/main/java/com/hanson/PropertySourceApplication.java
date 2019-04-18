package com.hanson;

import com.hanson.bean.ProperySourceBean;
import com.hanson.config.PropertySourceConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PropertySourceConfiguration.class);
        context.refresh();
        ProperySourceBean bean = context.getBean(ProperySourceBean.class);

        System.out.println(bean);

        context.close();
    }
}
