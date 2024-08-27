package com.kq;

import cn.hutool.core.io.IoUtil;
import com.kq.service.UserDao;
import com.kq.service.UserService;
import com.kq.springframework.beans.PropertyValue;
import com.kq.springframework.beans.PropertyValues;
import com.kq.springframework.beans.factory.config.BeanDefinition;
import com.kq.springframework.beans.factory.config.BeanReference;
import com.kq.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.kq.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.kq.springframework.core.DefaultResourceLoader;
import com.kq.springframework.core.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author kq
 * 2024-07-06 11:03
 **/
public class BeanFactoryTest {

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }



}
