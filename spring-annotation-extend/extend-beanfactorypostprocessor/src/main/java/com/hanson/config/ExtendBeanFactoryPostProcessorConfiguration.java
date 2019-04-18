package com.hanson.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * {@link BeanPostProcessor}:Bean的后置处理器，在Bean的初始化方法执行前后执行
 * {@link BeanFactoryPostProcessor}:BeanFactory的后置处理器，在BeanFactory标准初始化之后调用。
 * 标准初始化：是指所有的BeanDefinitions信息已经被加载保存到BeanFactory中，但是还没有被实例化。
 *
 * 源码分析执行步骤：
 * 1）、创建IOC容器
 * 2）、invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessor
 *       1）、BeanFactory查找到所有的BeanFactoryPostProcessor类型的组件，并执行他们的方法postProcessBeanFactory
 *       2）、在初始化(finishBeanFactoryInitialization)创建其他组件前面执行
 *
 */


@Configuration
@ComponentScan
public class ExtendBeanFactoryPostProcessorConfiguration {

    @Bean
    public Example example() {
        return new Example();
    }


}
