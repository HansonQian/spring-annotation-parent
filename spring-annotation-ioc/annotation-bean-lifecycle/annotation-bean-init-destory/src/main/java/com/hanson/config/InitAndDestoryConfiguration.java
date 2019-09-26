package com.hanson.config;

import com.hanson.bean.Apple;
import com.hanson.bean.Blueberry;
import com.hanson.bean.Orange;
import com.hanson.bean.Pear;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * IOC容器中Bean的生命周期主要包括:Bean的创建-->Bean的初始化-->Bean的销毁 这一过程
 * <p>
 * 一、IOC容器管理Bean的生命周期:
 * 1)、调用构造函数创建对象
 * --1.1)、单实例对象:IOC容器启动的时候创建对象
 * --1.2)、多实例对象:在每次获取的时候创建对象
 * 2)、Bean的初始化
 * --2.1)、对象创建完成并为期属性赋值完成之后,调用初始化方法
 * 3)、Bean的销毁
 * --3.1)、单实例对象:IOC容器关闭的时候执行Bean的销毁方法
 * --3.2)、多实例对象:IOC容器不会调用销毁方法
 * </p>
 * 二、指定Bean对象的初始化和销毁方法的四种方式
 * 1)、通过@Bean注解的属性initMethod指定初始化方法;使用属性destroyMethod指定销毁方法
 * 2)、实现InitializingBean和DisposableBean接口
 * --2.1)、实现接口InitializingBean覆写afterPropertiesSet方法,该方法会在当前Bean对象创建成功并为属性赋值完成之后调用
 * --2.2)、实现接口DisposableBean覆写destroy方法,该方法会在容器关闭的时候调用[单例对象有效]
 * 3)、使用JSR250规范提供的两个注解@PostConstructor和@PreDestroy
 * --3.1)、注解@PostConstructor标注在初始化方法上,该方法会在当前Bean对象创建成功并为属性赋值完成之后调用
 * --3.2)、注解@PreDestory标注在销毁方法上,该方法会在容器关闭的时候调用[单例对象有效]
 * 4)、实现{@link org.springframework.beans.factory.config.BeanPostProcessor }接口,在Bean初始化方法前后进行一些处理工作
 * --4.1)、覆写方法postProcessBeforeInitialization,该方法会在调用初始化方法之前调用
 * --4.2)、覆写方法postProcessAfterInitialization,该方法会在调用完初始化方法之后调用
 * --4.3)、IOC容器会首先遍历容器中全部的后处理Bean接口实现类;然后挨个执行postProcessBeforeInitialization方法.
 * 在执行过程中一旦遇到返回null,则会调出循环;即而不会继续执行后面的postProcessBeforeInitialization方法
 * --4.4)、{@link org.springframework.beans.factory.config.BeanPostProcessor }原理
 * ----4.4.1)、第一步进入 populateBean(beanName, mbd, instanceWrapper)方法;给bean进行属性赋值
 * ----4.4.2)、第二步调用初始化Bean方法 initializeBean
 * ------4.4.2.1)、调用applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 * ------4.4.2.2)、invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
 * ------4.4.2.3)、applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * --4.5)、后处理Bean在Spring 中的应用
 * ----4.5.1)、给Bean赋值
 * ----4.5.2)、注入其他组件
 * ----4.5.3)、实现依赖注入@Autowired
 * ----4.5.4)、Bean生命周期注解功能
 * ----4.5.5)、@Async异步执行注解
 * ----4.5.6)、以及若干XXXBeanPostProcessor
 */


@Configuration
public class InitAndDestoryConfiguration {

    /**
     * 方式一:基于@Bean注解属性指定Bean的初始化和销毁方法
     *
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Apple apple() {
        Apple apple = new Apple();
        apple.setColor("red");
        return apple;
    }

    /**
     * 方式二:实现InitializingBean和DisposableBean接口
     *
     * @return
     */
    @Bean
    public Blueberry blueberry() {
        Blueberry blueberry = new Blueberry();
        blueberry.setColor("Blue");
        return blueberry;
    }

    /**
     * 方式三:基于JSR250规范提供的注解指定Bean的初始化和销毁方法
     *
     * @return
     */
    @Bean
    public Pear pear() {
        Pear pear = new Pear();
        pear.setColor("Yellow");
        return pear;
    }

    /**
     * 方式四:实现后处理Bean接口覆写两个接口方法
     *
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Orange orange() {
        Orange orange = new Orange();
        orange.setColor("Orange");
        return orange;
    }
}
