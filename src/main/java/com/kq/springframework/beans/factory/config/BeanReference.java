package com.kq.springframework.beans.factory.config;

/**
 * @author kq
 * 2024-07-07 13:04
 * Bean 的引用
 **/
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
