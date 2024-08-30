package com.kq.springframework.beans.factory;

import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.kq.springframework.beans.factory.config.BeanDefinition;
import com.kq.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author kq
 * 2024-08-27 21:29
 * 它扩展了 ListableBeanFactory 和 HierarchicalBeanFactory 接口。
 * 这个接口为 BeanFactory 提供了更多的配置能力，使得开发人员可以在运行时动态地配置和修改 Bean 的定义。
 **/
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
