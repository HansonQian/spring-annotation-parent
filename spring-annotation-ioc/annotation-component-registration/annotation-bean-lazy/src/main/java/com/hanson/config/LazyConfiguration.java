package com.hanson.config;

import com.hanson.bean.LazyBean;
import com.hanson.bean.PositiveBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * 使用注解@Lazy实现单实例Bean的懒加载
 * <p>
 * 单实例Bean 默认是在容器启动的时候创建实例
 * 懒加载实现的效果是 容器启动的时候不创建对象,而是在第一次获取Bean的时候创建对象,并初始化
 */

@Configuration
public class LazyConfiguration {
    @Bean
    @Lazy
    public LazyBean lazyBean() {
        return new LazyBean();
    }
    @Bean
    public PositiveBean positiveBean() {
        return new PositiveBean();
    }
}
