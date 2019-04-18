package com.hanson;

import com.hanson.bean.PrototypeBean;
import com.hanson.bean.SingletonBean;
import com.hanson.config.ScopeConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfiguration.class);

        SingletonBean beanA = applicationContext.getBean(SingletonBean.class);
        SingletonBean beanB = applicationContext.getBean(SingletonBean.class);

        System.out.println(beanA == beanB);

        PrototypeBean beanC = applicationContext.getBean(PrototypeBean.class);
        PrototypeBean beanD = applicationContext.getBean(PrototypeBean.class);

        System.out.println(beanC == beanD);

        applicationContext.close();
    }
}
