package com.kq.springframework.beans.factory.support;

import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author kq
 * 2024-07-07 11:20
 * Bean 实例化策略
 **/
public interface InstantiationStrategy {

    /**
     * Bean 的实例化
     * @param beanDefinition Bean 定义信息，Class 信息
     * @param beanName 实例化的 Bean 名称
     * @param ctor 构造器
     * @param args 构造方法
     * @return 实例化的 Bean
     * @throws BeansException Bean 实例化异常
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName,
                       Constructor<?> ctor, Object[] args) throws BeansException;

}
