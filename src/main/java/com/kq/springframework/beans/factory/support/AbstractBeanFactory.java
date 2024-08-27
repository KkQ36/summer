package com.kq.springframework.beans.factory.support;

import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.factory.BeanFactory;
import com.kq.springframework.beans.factory.config.BeanDefinition;

/**
 * @author kq
 * 2024-07-06 19:43
 * 抽象的 Bean 工厂，定义实现 Bean 工厂的完整流程【模板模式】
 * 通过继承 DefaultSingletonBeanRegistry，获取单例 Bean 注册的能力
 **/
@SuppressWarnings("unchecked")
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    /**
     * 模板方法，实现 Bean 工厂的完整流程
     * @param name Bean name
     * @param args 构造函数参数
     * @return Bean
     * @param <T> Bean 类型
     */
    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    /**
     * 获取 BeanDefinition，交给子类去实现
     * @param beanName Bean name
     * @return BeanDefinition
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创建 Bean，交给子类去实现
     * @param beanName Bean name
     * @param beanDefinition BeanDefinition
     * @param args 构造函数参数
     * @return 创建的 Bean
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

}
