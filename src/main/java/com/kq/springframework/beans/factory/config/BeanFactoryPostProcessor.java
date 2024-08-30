package com.kq.springframework.beans.factory.config;

import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author kq
 * 2024-08-28 19:43
 * 允许开发人员在 Spring 应用上下文初始化过程中对 BeanFactory 进行自定义的修改或增强。
 * BeanFactoryPostProcessor 的主要作用是在所有的 BeanDefinition 被加载到 BeanFactory 后，但在任何 Bean 实例化之前，提供一个干预的机会。
 **/
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory 提供可配置 Bean 能力的 Bean 工厂
     * @throws BeansException 异常
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
