package com.kq.springframework.content.support;

import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.factory.config.BeanPostProcessor;
import com.kq.springframework.content.ApplicationContext;
import com.kq.springframework.content.ApplicationContextAware;

/**
 * @author kq
 * 2024-08-29 19:59
 **/
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
