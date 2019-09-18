package com.hanson;

import com.hanson.bean.Blue;
import com.hanson.config.ImportConfiguration;
import com.hanson.factory.BlueFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ImportApplication {
    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportConfiguration.class);

        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);

        //获取工厂Bean
        Object bean = context.getBean("&blueFactoryBean");
        System.out.println(bean.getClass());
        if (bean instanceof BlueFactoryBean){
            BlueFactoryBean blueFactoryBean = (BlueFactoryBean)bean;
            Blue blue = blueFactoryBean.getObject();
            System.out.println(blue);
        }
        context.close();
    }
}
