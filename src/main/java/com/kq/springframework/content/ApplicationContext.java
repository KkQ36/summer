package com.kq.springframework.content;

import com.kq.springframework.beans.factory.ListableBeanFactory;

/**
 * @author kq
 * 2024-08-28 19:50
 * 应用上下文，是 Spring 暴露的接口，用于获取 BeanFactory 和其他资源。
 **/
public interface ApplicationContext extends ListableBeanFactory { }
