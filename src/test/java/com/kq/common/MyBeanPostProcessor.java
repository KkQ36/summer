package com.kq.common;

import com.kq.service.UserService;
import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author kq
 * 2024-08-28 20:42
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
