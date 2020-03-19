package com.hanson;

import com.hanson.bean.Child;
import com.hanson.config.AutowiredConfiguration;
import com.hanson.web.ChildController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AutowiredConfiguration.class);
        ChildController controller = context.getBean(ChildController.class);
        Child child = new Child();
        controller.submitForm(child);
        context.close();
    }
}
