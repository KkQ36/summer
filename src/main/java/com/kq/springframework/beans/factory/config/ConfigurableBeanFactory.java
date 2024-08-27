package com.kq.springframework.beans.factory.config;

import com.kq.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author kq
 * 2024-08-27 21:31
 * 可配置的 Bean 工厂，提供了 Bean 的作用域配置
 **/
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
