package com.kq.springframework.content;

import com.kq.springframework.beans.BeansException;

/**
 * @author kq
 * 2024-08-29 19:46
 * 实现此接口，既能感知到所属的 ApplicationContext
 **/
public interface ApplicationContextAware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
