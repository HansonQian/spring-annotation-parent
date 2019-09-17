package com.hanson.config;

import com.hanson.bean.PropertySourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * 使用注解@PropertySource加载外部属性配置文件保存到运行的环境变量中
 * 也可以使用@PropertySources来管理多个@PropertySource
 * <code> @PropertySources({@PropertySource("classpath:application.properties")}) </code>
 */

@Configuration
@PropertySource({"classpath:application.properties"})
public class PropertySourceConfiguration {


    @Bean
    public PropertySourceBean propertySourceBean() {
        return new PropertySourceBean();
    }
}
