package com.kq.common;

import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.PropertyValue;
import com.kq.springframework.beans.PropertyValues;
import com.kq.springframework.beans.factory.config.BeanDefinition;
import com.kq.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.kq.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author kq
 * 2024-08-28 20:41
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
