package com.hanson;

import com.hanson.config.ExtendApplicationListenerConfiguration;
import com.hanson.event.CustomEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtendApplicationListenerApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtendApplicationListenerConfiguration.class);
        context.publishEvent(new CustomEvent(new String("发布一个事件")));
        context.close();
    }
}
