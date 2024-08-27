package com.kq.springframework.beans.factory;

import com.kq.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author kq
 * 2024-08-27 21:26
 * 这个接口的主要目的是提供了一种机制来枚举和访问 IoC（Inversion of Control）容器中注册的所有 Bean 的元数据。
 * 通过实现 ListableBeanFactory 接口，容器能够支持对所有已注册 Bean 的遍历和检索。
 **/
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回 Bean 实例
     * @param type Bean 类型
     * @param <T> 泛型
     * @return key 为 Bean 名称，value 为 Bean 实例
     * @throws BeansException 异常
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();


}
