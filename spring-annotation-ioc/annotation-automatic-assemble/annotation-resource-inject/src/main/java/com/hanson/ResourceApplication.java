package com.hanson;

import com.hanson.bean.Computer;
import com.hanson.config.ResourceConfiguration;
import com.hanson.web.controller.ComputerController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;

public class ResourceApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ResourceConfiguration.class);

        ComputerController computerController = applicationContext.getBean(ComputerController.class);
        Computer computer = new Computer();
        computerController.add(computer);


        Method close = applicationContext.getClass().getMethod("close");
        close.setAccessible(true);
        close.invoke(applicationContext);
    }
}
