package com.kq;

import com.kq.interceptor.SimpleMethodInterceptor;
import com.kq.service.UserService;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * @author kq
 * 2024-08-04 21:05
 * CGLIB 测试
 **/
public class CgLibTest {

    @Test
    public void textBeanCreation() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new SimpleMethodInterceptor());
        UserService proxy = (UserService)enhancer.create();
        proxy.test();
    }

}