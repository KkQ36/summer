package com.kq.springframework.beans.factory;

/**
 * @author kq
 * 2024-08-27 21:28
 * 继承结构 Bean 工厂
 * HierarchicalBeanFactory 接口在 Spring 框架中定义了具有层次结构的 BeanFactory。这意味着它可以创建父子层次的 BeanFactory 实例，
 * 其中子 BeanFactory 可以访问其父 BeanFactory 中定义的 Bean，而父 BeanFactory 无法访问子 BeanFactory 中的 Bean。
 **/
public interface HierarchicalBeanFactory extends BeanFactory {
}
