package com.hanson.config;

import com.hanson.bean.ValueBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValueConfiguration {

    @Bean
    public ValueBean valueBean() {
        return new ValueBean();
    }
}
