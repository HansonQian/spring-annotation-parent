package com.hanson.registrar;

import com.hanson.bean.Green;
import com.hanson.bean.Orange;
import com.hanson.bean.Yellow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义导入Bean定义的登记器，该方式为手工注册,即注册到容器的权限是由程序员手工控制
 */
public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @param registry               BeanDefinition注册类
     *                               把所有需要添加到容器中的bean 调用BeanDefinitionRegistry.registerBeanDefinition进行手工注册
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.hanson.bean.Red");
        boolean color = registry.containsBeanDefinition("com.hanson.bean.Color");
        if (red && color) {
            registry.registerBeanDefinition("green", new RootBeanDefinition(Green.class));
            registry.registerBeanDefinition("orange", new RootBeanDefinition(Orange.class));
            registry.registerBeanDefinition("yellow", new RootBeanDefinition(Yellow.class));
        }
    }
}
