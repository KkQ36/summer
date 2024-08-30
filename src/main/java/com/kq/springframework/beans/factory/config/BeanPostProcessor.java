package com.kq.springframework.beans.factory.config;

import com.kq.springframework.beans.BeansException;

/**
 * @author kq
 * 2024-08-28 19:48
 * 允许开发者在 Spring 容器管理的 Bean 初始化前后添加自定义的处理逻辑。
 **/
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean Bean 对象
     * @param beanName Bean 名称
     * @return 处理后的 Bean 对象
     * @throws BeansException 异常
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     * @param bean Bean 对象
     * @param beanName Bean 名称
     * @return 处理后的 Bean 对象
     * @throws BeansException 异常
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}