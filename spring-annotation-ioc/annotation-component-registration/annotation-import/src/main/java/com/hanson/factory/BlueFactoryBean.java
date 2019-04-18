package com.hanson.factory;

import com.hanson.bean.Blue;
import org.springframework.beans.factory.FactoryBean;

/**
 */
public class BlueFactoryBean implements FactoryBean<Blue> {

    /**
     * 返回一个Blue对象, 这个对象会添加到容器中
     *
     * @return
     * @throws Exception
     */
    @Override
    public Blue getObject() throws Exception {
        System.out.println("*******BlueFactoryBean*******");
        return new Blue();
    }

    /**
     * 返回对象类型
     *
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Blue.class;
    }

    /**
     * 控制是否为单例
     *
     * @return true：标识是单例,容器中保存一份
     * false 则每次调用都返回新的
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
