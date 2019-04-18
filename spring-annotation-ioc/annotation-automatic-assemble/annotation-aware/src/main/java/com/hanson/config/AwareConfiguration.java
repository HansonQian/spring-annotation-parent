package com.hanson.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义组件想要使用Spring容器底层的一些组件(eg:ApplicationContext、BeanFactory等等)
 * 只需要实现xxxAware，在创建对象的时候,会调用接口规定的方法注入相关的底层组件
 * 原理是通过对应的后置处理器{@link org.springframework.context.support.ApplicationContextAwareProcessor}完成的
 * 参考接口{@link org.springframework.beans.factory.Aware} 接口
 */
@Configuration
@ComponentScan(basePackages = {"com.hanson"})
public class AwareConfiguration {
}
