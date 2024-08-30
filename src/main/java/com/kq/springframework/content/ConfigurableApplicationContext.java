package com.kq.springframework.content;

import com.kq.springframework.beans.BeansException;

/**
 * @author kq
 * 2024-08-28 19:53
 * ConfigurableApplicationContext 是 Spring 框架中的一个接口，它是 ApplicationContext 的子接口，提供了更多的配置和控制功能。
 * 常用方法
 * ConfigurableApplicationContext 提供了一些重要的方法，包括：
 *    refresh(): 刷新上下文，加载所有 Bean 定义并初始化它们。
 *    close(): 关闭上下文，释放所有资源。
 *    registerShutdownHook(): 注册一个 JVM 关闭钩子，在 JVM 关闭时自动关闭上下文。
 **/
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException 异常
     */
    void refresh() throws BeansException;

    /**
     * 向 JVM 注册关闭钩子接口
     */
    void registerShutdownHook();

    /**
     * 关闭容器
     */
    void close();

}
