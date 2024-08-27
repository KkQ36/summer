package com.kq.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author kq
 * 2024-08-04 21:07
 **/
public class SimpleMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before method: " + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("After method: " + method.getName());
        return result;
    }

}