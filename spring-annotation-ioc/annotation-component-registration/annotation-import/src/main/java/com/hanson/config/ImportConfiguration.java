package com.hanson.config;

import com.hanson.bean.Blue;
import com.hanson.bean.Color;
import com.hanson.factory.BlueFactoryBean;
import com.hanson.registrar.CustomImportBeanDefinitionRegistrar;
import com.hanson.selector.CustomImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring中给容器注册组件的方式:
 * 1)、在组件上使用特定的注解(@Controller、@Service等)结合组件扫描器(@ComponentScan)
 * 2)、使用@Bean注解,该方式常用于引入第三方组件
 * 3)、使用@Import注解,快速导入组件,id默认是组件的全类目[Spring Boot框架的重点]
 * -- 3.1)、@Import(要导入到容器中的组件字节码文件),容器中就会自动注册这个主键,id默认是这个组件的全限定名称
 * -- 3.2)、使用ImportSelector接口,该接口返回 需要导入的 组件全类名数组(交给容器注册) 示例程序 {@link CustomImportSelector}
 * -- 3.3)、使用ImportBeanDefinitionRegistrar注册组件(手工注册) 示例程序 {@link CustomImportBeanDefinitionRegistrar}
 * 4)、使用Spring提供的FactoryBean(工厂Bean) 示例程序 {@link BlueFactoryBean}
 * -- 4.1)、默认获取到的是工厂Bean调用getObject创建的对象
 * -- 4.2)、要获取工厂Bean本身,需要在id前面拼接&
 * 5)、实现接口BeanDefinitionRegistryPostProcessor接口覆写postProcessBeanDefinitionRegistry方法注册
 */
@Configuration
@Import({Color.class, CustomImportSelector.class, CustomImportBeanDefinitionRegistrar.class})
public class ImportConfiguration {

    @Bean
    public BlueFactoryBean blueFactoryBean() {
        return new BlueFactoryBean();
    }

}
