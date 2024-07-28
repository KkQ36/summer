package com.kq.springframework.beans.factory.support;

import com.kq.springframework.beans.factory.config.BeanDefinition;

/**
 * @author kq
 * 2024-07-06 19:38
 * 定义 Bean 注册的接口
 **/
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
