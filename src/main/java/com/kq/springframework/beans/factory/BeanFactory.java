package com.kq.springframework.beans.factory;

import com.kq.springframework.beans.BeansException;

/**
 * @author kq
 * 2024-07-06 19:33
 * Bean 工厂接口，定义了 getBean 的方法
 **/
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
