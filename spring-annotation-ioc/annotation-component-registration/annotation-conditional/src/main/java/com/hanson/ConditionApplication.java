package com.hanson;

import com.hanson.bean.OperatingSystem;
import com.hanson.config.ConditionConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 示例程序说明：
 * 根据应用运行的环境判断当前环境处于什么系统
 */
public class ConditionApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionConfiguration.class);

        OperatingSystem bean = applicationContext.getBean(OperatingSystem.class);
        System.out.println(bean);

        applicationContext.close();

    }
}
