package com.hanson.config;

import com.hanson.bean.Beauty;
import com.hanson.bean.Girl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 注解@Autowired作用范围是：构造器，参数，方法，属性.都是从IOC容器获取对应Bean组件并赋值
 * 1)、方法
 * 2)、构造器，如果只有一个有参构造器,这个参数构造器的@Autowired可以省略.参数位置的组件还是可以从容器中获取
 * 3)、参数
 * 4)、属性
 */

@Configuration
@ComponentScan(basePackages = {"com.hanson.bean"})
public class AutowiredPlaceConfiguration {


    /**
     * 标注@Bean的方法创建对象的时候,方法参数的值从容器中获取
     *
     * @param beauty
     * @return
     */
    @Bean("girl2")
    public Girl girl(Beauty beauty) {
        Girl girl = new Girl();
        girl.setBeauty(beauty);
        return girl;
    }
}
