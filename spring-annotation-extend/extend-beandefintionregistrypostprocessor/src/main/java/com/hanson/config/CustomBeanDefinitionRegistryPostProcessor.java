package com.hanson.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * @param registry BeanDefinitionRegistry用于保存Bean的定义信息，BeanFactory根据BeanDefinitionRegistry创建Bean的实例
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println(">>>>CustomBeanDefinitionRegistryPostProcessor###postProcessBeanDefinitionRegistry>>>容器中Bean有:" + registry.getBeanDefinitionCount() + "个");
        registry.registerBeanDefinition("example",new RootBeanDefinition(Example.class));
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(">>>>CustomBeanDefinitionRegistryPostProcessor###postProcessBeanFactory>>>容器中Bean有:" + beanFactory.getBeanDefinitionCount() + "个");
    }
}
