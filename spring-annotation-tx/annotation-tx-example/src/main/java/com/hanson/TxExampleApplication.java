package com.hanson;

import com.hanson.config.TxExampleConfiguration;
import com.hanson.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxExampleApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxExampleConfiguration.class);
        UserService bean = applicationContext.getBean(UserService.class);
        bean.save();
        applicationContext.close();
    }
}
