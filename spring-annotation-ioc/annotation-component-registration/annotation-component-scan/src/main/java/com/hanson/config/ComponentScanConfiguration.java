package com.hanson.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.TypeFilter;


/**
 * 说明:
 * 使用@ComponentScan注解来指定要扫描的包
 * 1)、使用注解属性value或者basePackages也或者是basePackageClasses指定要扫描的包
 * 2)、使用注解属性excludeFilters指定扫描的时候按照扫描规则排除哪些组件
 * 3)、使用注解属性includeFilters指定扫描的时候按照扫描规则包含哪些组件.要使includeFilters组件生效,需要关闭默认的过滤规则.
 * 注解的属性useDefaultFilters默认值为true需要将该值改为false
 * 4)、在JDK1.8中@ComponentScan注解是一个可以重复使用的注解.使用@ComponentScans来管理@ComponentScan注解
 * </p>
 * 过滤规则说明:
 * excludeFilters和includeFilters的属性值
 * 1)、FilterType.ANNOTATION        按照注解 来指定包含或者排除扫描的过滤规则
 * 2)、FilterType.ASSIGNABLE_TYPE   按照给定的类型 来指定包含或者排除扫描的过滤规则
 * 3)、FilterType.ASPECTJ           使用ASPECTJ表达式
 * 4)、FilterType.REGEX             使用正则表达式
 * 5)、FilterType.CUSTOM            使用自定义过滤规则,需要实现接口{@link TypeFilter}
 */


@Configuration
@ComponentScan(basePackages = {"com.hanson"},
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM,
                        classes = {CustomizeTypeFilter.class})},
        useDefaultFilters = false)
public class ComponentScanConfiguration {
}
