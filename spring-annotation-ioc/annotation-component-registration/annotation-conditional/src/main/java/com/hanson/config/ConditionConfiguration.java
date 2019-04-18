package com.hanson.config;

import com.hanson.bean.OperatingSystem;
import com.hanson.condition.LinuxCondition;
import com.hanson.condition.WindowCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：
 * 使用@Conditional注解,按照一定的条件进行判断,满足条件则给容器注册Bean
 * 否则不注册,该注解可以标注在类级别上,意味着整个类属性都需要满足这个条件才能被注册到容器中
 */
@Configuration
public class ConditionConfiguration {


    @Bean
    @Conditional({WindowCondition.class})
    public OperatingSystem windows() {
        return new OperatingSystem("当前系统为 windows 系统");
    }

    @Bean
    @Conditional({LinuxCondition.class})
    public OperatingSystem linux() {
        return new OperatingSystem("当前系统为 linux 系统");
    }
}
