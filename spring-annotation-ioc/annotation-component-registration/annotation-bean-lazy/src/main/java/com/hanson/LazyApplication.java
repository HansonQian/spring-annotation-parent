package com.hanson;

import com.hanson.bean.LazyBean;
import com.hanson.bean.PositiveBean;
import com.hanson.config.LazyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LazyConfiguration.class);

        applicationContext.getBean(LazyBean.class);

        applicationContext.getBean(PositiveBean.class);

        applicationContext.close();
    }
}
