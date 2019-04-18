package com.hanson.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ApplicationListener：监听容器中发布的事件。事件驱动模型开发
 * <code>
 * public interface ApplicationListener<E extends ApplicationEvent>{
 * <p>
 * }
 * </code>
 * 监听ApplicationEvent及其子事件。
 * <p>
 * 自定义开发事件监听器步骤：
 * 1）、编写一个监听器来监听某个事件（事件必须是ApplicationEvent及其子类）
 * 2）、把监听器交给IOC容器
 * 3）、只要容器中有相关的事件发布，即可监听到该事件
 * ContextRefreshedEvent:容器刷新完成，所有Bean创建完成
 * ContextClosedEvent:容器关闭的时候事件
 * 自定义开发事件步骤
 * 1）、创建一个类实现ApplicationEvent接口
 * 2）、利用IOC容器示例的publishEvent方法发布事件
 * <code>
 * AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtendApplicationListenerConfiguration.class);
 *  context.publishEvent(new CustomEvent(new String("发布一个事件")));
 *  context.close();
 * </code>
 *
 * ApplicationListener实现原理（以ContextRefreshedEvent事件为例分析）
 * 1）、容器创建对象，refresh()
 * 2）、finishRefresh()容器刷新完成
 * 3）、publishEvent(new ContextRefreshedEvent(this))
 *  3.1)、获取事件的派发器：getApplicationEventMulticaster()
 *  3.2)、multicastEvent派发事件
 *  3.3)、获取到所有的ApplicationListener:getApplicationListeners(event, type)
 *      3.3.1）、如果有Executor，可以支持使用Executor进行异步派发：getTaskExecutor()
 *      3.3.2）、否则，同步执行直接调用 invokeListener(listener, event);
 *      获取到listener回调onApplicationEvent方法
 *
 * 事件派发器的获取
 * 1、refresh()方法
 * 2、initApplicationEventMulticaster()方法
 *      this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *      beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, this.applicationEventMulticaster);
 *
 * 容器中存在哪些监听器
 * 1）、refresh()方法
 * 2）、registerListeners();注册监听器
 * 3)、获取监听器，并将所有的监听器添加到事件派发器中
 * <code>
 *     		String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *            for (String listenerBeanName : listenerBeanNames) {
 *                  getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *            }
 * </code>
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.hanson"})
public class ExtendApplicationListenerConfiguration {
}
