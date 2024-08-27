package com.kq.springframework.beans.factory.support;

import com.kq.springframework.beans.BeansException;
import com.kq.springframework.core.DefaultResourceLoader;
import com.kq.springframework.core.Resource;
import com.kq.springframework.core.ResourceLoader;

/**
 * @author kq
 * 2024-08-27 21:00
 *
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }


    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
