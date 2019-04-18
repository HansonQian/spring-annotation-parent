package com.hanson.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 该类会再标准初始化之后被调用
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(">>>>CustomBeanFactoryPostProcessor>>>>postProcessBeanFactory");

        int definitionCount = beanFactory.getBeanDefinitionCount();

        System.out.println(">>>>当前BeanFactory中存在的Bean个数为:" + definitionCount);

        System.out.println(">>>>当前容器中所有Bean的名字>>>>");

        Arrays.asList(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
