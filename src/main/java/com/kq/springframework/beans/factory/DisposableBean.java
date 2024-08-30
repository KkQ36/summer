package com.kq.springframework.beans.factory;

/**
 * @author kq
 * 2024-08-29 18:36
 * 定义了 Bean 对象销毁的时候要执行的方法
 **/
public interface DisposableBean {

    /**
     * Bean 对象销毁时调用
     * @throws Exception 异常
     */
    void destroy() throws Exception;

}
