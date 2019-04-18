package com.hanson.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListenerMethodProcessor;


/**
 * 事件监听
 * 除了写一个监听器（ApplicationListener实现类）来监听某个事件（ApplicationEvent及其子类）也可以
 * 通过使用@EventListener来完成事件监听
 *
 * 实现原理：{@link EventListenerMethodProcessor } 事件监听方法处理器
 * 该处理器实现了SmartInitializingSingleton接口
 * 该接口的方法（afterSingletonsInstantiated）会在所有单实例Bean初始化完成之后被调用
 *
 * 源码分析执行过程：
 * 1、创建IOC容器，调用refresh方法
 * 2、调用finishBeanFactoryInitialization方法，完成单实例Bean的初始化工作
 *  2.1、调用getBean方法，先创建所有的单实例Bean
 *  2.2、获取所有创建好的单实例Bean，判断是否是SmartInitializingSingleton类型
 *      如果是再去调用afterSingletonsInstantiated方法
 *
 */

@Configuration
@ComponentScan("com.hanson")
public class ExtendEventListenerConfiguration {
}
