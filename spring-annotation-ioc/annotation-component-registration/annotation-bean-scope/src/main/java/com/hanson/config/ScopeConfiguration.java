package com.hanson.config;

import com.hanson.bean.PrototypeBean;
import com.hanson.bean.SingletonBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 注解@Scope说明
 * 使用@Scope注解来设置Bean的作用域,默认为单例.该注解的作用范围是类、方法级别
 * 该注解属性scopeName的取值有如下几种
 * 1)、ConfigurableBeanFactory#SCOPE_PROTOTYPE 原型,多实例
 * 2)、ConfigurableBeanFactory#SCOPE_SINGLETON 单例
 * 3)、org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  Web环境下Request
 * 4)、org.springframework.web.context.WebApplicationContext#SCOPE_SESSION   Web环境下Session
 */

@Configuration
public class ScopeConfiguration {

    @Bean
    public SingletonBean scopeBean() {
        return new SingletonBean();
    }

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

}
