package com.kq.springframework.beans.factory;

/**
 * @author kq
 * 2024-08-29 20:14
 **/
public interface BeanNameAware extends Aware{

    void setBeanName(String name);

}
