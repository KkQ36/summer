package com.kq.springframework.beans.factory.support;

import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.factory.config.BeanDefinition;

/**
 * @author kq
 * 2024-07-06 19:38
 * 定义了注册 BeanDefinition 的方法
 **/
public interface BeanDefinitionRegistry {

    /**
     * 注册 BeanDefinition
     * @param beanName Bean 名称
     * @param beanDefinition Bean 定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 使用Bean名称查询BeanDefinition
     * @param beanName Bean 名称
     * @throws BeansException 异常
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName Bean 名称
     * @return 包含为是，不包含为否
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * Return the names of all beans defined in this registry.
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();



}
