package com.kq.springframework.beans.factory;

import com.kq.springframework.beans.BeansException;

/**
 * @author kq
 * 2024-08-29 19:43
 * 实现此接口，既能感知到所属的 BeanFactory
 **/
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
