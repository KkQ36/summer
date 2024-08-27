package com.kq.springframework.beans.factory.support;

import com.kq.springframework.beans.BeansException;
import com.kq.springframework.core.Resource;
import com.kq.springframework.core.ResourceLoader;

/**
 * @author kq
 * 2024-08-27 20:58
 * Bean 定义读取器接口，定义了加载 Bean 定义的方法
 **/
public interface BeanDefinitionReader {

    /**
     * Bean 定义注册机，存储 Bean 定义的位置
     * @return BeanDefinitionRegistry
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     * @return ResourceLoader
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载 Bean 定义，将其添加到 Bean 定义注册器
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
