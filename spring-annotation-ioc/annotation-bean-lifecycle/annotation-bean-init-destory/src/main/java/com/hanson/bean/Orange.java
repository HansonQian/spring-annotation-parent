package com.hanson.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 实现{@link BeanPostProcessor }接口
 */
public class Orange implements BeanPostProcessor {

    private String color;


    public Orange() {
        System.out.println("****Implement BeanPostProcessor **** Orange constructor is called ...");
    }

    public Orange(String color) {
        this.color = color;
    }


    /**
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof Orange) {
            System.out.println("****在调用初始化方法之前调用 ...");
        }

        return bean;
    }

    /**
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Orange) {
            System.out.println("****在调用初始化方法之后调用 ...");
        }
        return bean;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("****Implement BeanPostProcessor **** Orange attribute assignment ...");
        this.color = color;
    }


    public void init() {
        System.out.println("****Implement BeanPostProcessor **** Orange init is called ...");
    }

    public void destory() {
        System.out.println("****Implement BeanPostProcessor **** Orange destory is called ...");
    }
}
