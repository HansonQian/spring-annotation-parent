package com.hanson.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boy {

    private Girl girl;

    /**
     * 构造器的参数也是从IOC容器中获取的
     *
     * @param girl
     */
    public Boy(@Autowired Girl girl) {
        this.girl = girl;
        System.out.println("有参构造器....");
    }


    /**
     * 注解@Autowired标注在方法上,Spring容器创建当前对象,就会调用方法,完成赋值
     * 方法使用的参数,自定义类型的值从ioc容器中获取
     *
     * @param girl
     */
    //@Autowired
    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
