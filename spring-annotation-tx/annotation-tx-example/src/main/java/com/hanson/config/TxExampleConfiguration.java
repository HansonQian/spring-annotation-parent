package com.hanson.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Spring 事务开发步骤
 * 1）、添加spring-jdbc依赖、数据源依赖、数据库连接驱动依赖
 * 2）、配置数据源
 * 3）、配置JdbcTemplate
 * 4）、给指定方法或者类上添加上@Transactional注解用来表示当前方法(当前类)是一个事务方法(事务类)
 * 5）、使用@EnableTransactionManagement开启基于注解的事务管理功能
 * 6）、配置事务管理器,事务管理器需要定制的话参考{@link TransactionManagementConfigurer}
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.hanson"})
public class TxExampleConfiguration {

    /**
     * 配置数据源
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    /**
     * 配置JDBC模板
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 配置事务管理器,
     */
    @Bean
    public PlatformTransactionManager txManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
