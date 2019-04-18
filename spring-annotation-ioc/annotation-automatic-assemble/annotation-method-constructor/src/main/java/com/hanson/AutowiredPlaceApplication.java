package com.hanson;

import com.hanson.bean.Boy;
import com.hanson.config.AutowiredPlaceConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;

public class AutowiredPlaceApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredPlaceConfiguration.class);

        Boy boy = applicationContext.getBean(Boy.class);
        System.out.println(boy);

        Method close = applicationContext.getClass().getMethod("close");
        close.setAccessible(true);
        close.invoke(applicationContext);
    }
}
