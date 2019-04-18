package com.hanson.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;

/**
 * AOP:是指在运行期间动态的将某段代码切入到指定位置进行运行的编码方式
 * <p>
 * AOP功能开发步骤
 * 1)、导入aop模块
 * 2)、定义一个业务逻辑类
 * --2.1)、在业务逻辑运行的时候,打印日志(方法之前、方法运行结束、方法运行异常)
 * 3)、定义一个日志切面类 {@link com.hanson.aspect.LogAspect}
 * --3.1)、动态感知目标方法运行到具体哪一步骤
 * --3.2)、该类里面定义通知方法
 * ----3.2.1)、前置通知(@Before): logStart方法,希望在目标方法运行之前执行
 * ----3.2.2)、后置通知(@After): logEnd方法,希望在目标方法运行结束之后运行,无论方法正常执行还是执行发生异常都会被执行
 * ----3.2.3)、返回通知(@AfterReturning): logReturn方法,希望在目标方法正常返回之后运行
 * ----3.2.4)、异常通知(@AfterThrowing)：logException方法,希望在目标方法出现异常之后运行
 * ----3.2.5)、环绕通知(@Around)：动态代理,需要手动执行目标方法(jointPoint.proceed())
 * 4)、给切面类的目标方法标注合适何地运行(通知注解)
 * 5)、将切面类(标注@Aspect注解的类)和业务逻辑类(目标方法所在的类)都加入到容器中
 * 6)、使用注解@EnableAspectJAutoProxy启动AOP功能
 * <p>
 * 使用{@link EnableAspectJAutoProxy}开启AOP功能原理分析
 * 1)、给IOC容器注册什么组件
 * 使用{@link EnableAspectJAutoProxy}注解会给IOC导入{@link org.springframework.context.annotation.AspectJAutoProxyRegistrar}组件.
 * 该组件实现了{@link ImportBeanDefinitionRegistrar}接口.在该组件中会给IOC容器注册一个
 * {@link org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator}组件,该组件在IOC容器中的Id为
 * org.springframework.aop.config.internalAutoProxyCreator
 * 2)、组件什么时候工作
 * 3)、组件具备什么功能
 * </p>
 */

@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = {"com.hanson"})
public class AopExampleConfiguration {
}
