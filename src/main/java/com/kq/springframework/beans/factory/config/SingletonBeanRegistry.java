package com.kq.springframework.beans.factory.config;

/**
 * @author kq
 * 2024-07-06 19:33
 * 单例注册机，提供获取单例 Bean 的接口
 *  {@link com.kq.springframework.beans.factory.support.DefaultSingletonBeanRegistry} 是它的直接实现类
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
