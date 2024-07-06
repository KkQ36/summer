package com.kq.springframework.beans.factory.config;

/**
 * @author kq
 * 2024-07-06 19:33
 * 单例注册表，定义了获取单例 Bean 的方法
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
