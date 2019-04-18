package com.hanson.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.*;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 注解 @Profile：指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 * 1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 * 2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3）、没有标注环境标识的bean在，任何环境下都是加载的；
 */
@Configuration
@ComponentScan(basePackages = {"com.hanson"})
@PropertySource({"classpath:db.properties"})
public class ProfileConfiguration implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String username;

    @Value("${db.password}")
    private String password;

    private String driver;

    /**
     * 测试环境
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    @Profile("test")
    public DataSource dataSourceTest() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setDriverClass(driver);
        return comboPooledDataSource;
    }

    /**
     * 开发环境
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    @Profile("dev")
    public DataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setDriverClass(driver);
        return comboPooledDataSource;
    }

    /**
     * 生产环境
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    @Profile("prod")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prod");
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setDriverClass(driver);
        return comboPooledDataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        driver = resolver.resolveStringValue("${db.driver}");
    }
}