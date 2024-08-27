package com.kq.springframework.beans.factory;

import com.kq.springframework.beans.BeansException;

/**
 * @author kq
 * 2024-07-06 19:33
 * Bean 工厂接口，定义了 getBean 的方法
 **/
public interface BeanFactory {

    /**
     * 通过 Bean 的名称获取 Bean
     * @param name Bean name
     * @return Bean
     * @throws BeansException 异常
     */
    Object getBean(String name) throws BeansException;

    /**
     * 通过 Bean 的名称获取 Bean，同时支持通过 Bean 的构造函数来创建 Bean
     * @param name Bean name
     * @param args 构造函数参数
     * @return Bean
     * @throws BeansException 异常
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 通过泛型获取指定类型的 Bean
     * @param name Bean name
     * @param requiredType 需要的类型
     * @return Bean
     * @param <T> Bean 对象类型
     * @throws BeansException 异常
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
