package com.hanson.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * {@link BeanDefinitionRegistryPostProcessor}继承{@link BeanFactoryPostProcessor}并且提供了
 * postProcessBeanDefinitionRegistry方法,该方法会在所有Bean的定义信息将要被加载,bean实例还未创建的时候执行
 * 该接口的方法优先于{@link BeanFactoryPostProcessor}执行
 *
 * 源码分析执行流程：
 * 1）、IOC容器创建
 * 2）、调用refresh方法中的invokeBeanFactoryPostProcessors方法
 * 3）、从容器中获取所有类型为BeanDefinitionRegistryPostProcessor的组件，
 *       3.1)、依次触发对postProcessBeanDefinitionRegistry方法的执行
 *       3.2)、再来触发对postProcessBeanFactory方法的执行
 * 4）、再从容器中找到类型为BeanFactoryPostProcessor的组件
 *      依次触发对postProcessBeanFactory方法的执行
 *
 */
@Configuration
@ComponentScan
public class ExtendBeanDefinitionRegistryPostProcessorConfiguration {
}
