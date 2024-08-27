package com.kq.springframework.beans.factory.support;

import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.factory.config.BeanDefinition;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kq
 * 2024-07-06 19:54
 * 默认(Default)，提供列举所有实例(Listable)的 Bean 工厂
 **/
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /**
     * BeanDefinitionMap，保存 BeanDefinition，key 为 Bean Name value 为 BeanDefinition
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

}
