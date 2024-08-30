package com.kq;

import com.kq.service.UserService;
import com.kq.springframework.content.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author kq
 * 2024-07-06 11:03
 **/
public class BeanFactoryTest {

    @Test
    public void test() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }

}
