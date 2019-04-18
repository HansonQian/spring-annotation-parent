package com.hanson.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring 支持使用@Resource(JSR250规范)和@Jnject(JSR330规范)注解完成自动装配[java规范]
 * 1)、使用@Resource：可以和@Autowired一样实现自动装配功能,默认是按照组件名称进行装配的
 * 可以通过注解属性name按照名称指定装配,但是没有支持@Primary功能没有支持@Autowired(required=false)
 * 2)、使用@Inject注解：需要导入javax.inject的包,和@Autowired的功能一样。没有支持@Autowired(required=false)
 * <p>
 * 自动装配原理:AutowiredAnnotationBeanPostProcessor完成自动装配功能
 */
@Configuration
@ComponentScan(basePackages = {"com.hanson"})
public class ResourceConfiguration {
}
