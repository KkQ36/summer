package com.kq.springframework.beans.factory.config;

/**
 * @author kq
 * 2024-07-07 13:04
 * Bean 的引用
 * 案例：
 * BeanA 如果引用 BeanB 的话，在 BeanDefinition 中
 * 就会存在 BeanReference 属性来引用 BeanB
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
