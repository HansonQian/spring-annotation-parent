package com.hanson.config;

import com.hanson.service.ChildService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 自动装配
 * Spring 利用依赖注入(DI),完成IOC容器中各个组件关系的依赖关系赋值
 * 1)、使用@Autowired注解优先按照类型,去容器中获取对应的Bean,如果找到即给属性赋值.
 * 2)、如果根据类型找到多个Bean,再将属性的名称作为Bean的id去容器中查找
 * 3)、使用@Qualifer指定需要装配的组件的id,而不是使用属性名
 * 4)、默认是需要将属性值一定要赋值好,如果没有在容器中找到组件,那么程序就会出错.
 *      可以通过@Autowired注解的属性required来改变,默认值为true也就是必须注入,当将值改为false,
 *      则会出现这种效果：如果容器中有对应的组件存在则注入;没有则对应组件不注入
 * 5)、使用@Primary注解,该注解意思是首选,主要的.让容器装配组件的时候可以指定某个组件为首先的组件,
 *      再进行依赖注入的时候优先注入标有@Primary的组件
 * <p>
 * <code>
 * 根据类型获取Bean组件
 * ChildController controller = applicationContext.getBean(ChildController.class);
 * </code>
 */

@Configuration
@ComponentScan(basePackages = {"com.hanson"})
public class AutowiredConfiguration {


    @Bean("childService2")
    public ChildService childService() {
        ChildService childService = new ChildService();
        childService.setTag("childService2");
        return childService;
    }
}
