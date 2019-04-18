package com.hanson;

import com.hanson.config.AopExampleConfiguration;
import com.hanson.service.MathCalculatorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AOP程序示例
 */
public class AopExmapleApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopExampleConfiguration.class);
        MathCalculatorService calculatorService = context.getBean(MathCalculatorService.class);
        calculatorService.div(4, 2);
        //context.close();
        //calculatorService.div(2,0);
    }
}
