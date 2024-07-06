package com.kq.springframework.beans.factory.config;

/**
 * @author kq
 * 2024-07-06 19:33
 * Bean 定义
 */
public class BeanDefinition {

    private Class<?> beanClass;

    public BeanDefinition(Class<?>  beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?>  beanClass) {
        this.beanClass = beanClass;
    }

}
