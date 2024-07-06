package com.kq;

import com.kq.service.UserService;
import com.kq.springframework.beans.factory.config.BeanDefinition;
import com.kq.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author kq
 * 2024-07-06 11:03
 **/
public class test {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        System.out.println(userService.hashCode());
        userService.queryUserInfo();

        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        System.out.println(userService_singleton.hashCode());
        userService_singleton.queryUserInfo();

    }

}
