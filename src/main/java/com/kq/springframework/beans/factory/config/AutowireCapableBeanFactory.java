package com.kq.springframework.beans.factory.config;

import com.kq.springframework.beans.BeansException;

/**
 * @author kq
 * 2024-08-27 21:30
 **/
public interface AutowireCapableBeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     * @param existingBean 实例化的 Bean
     * @param beanName Bean 名称
     * @return 处理过的 Bean
     * @throws BeansException 异常
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     * @param existingBean 实例化的 Bean
     * @param beanName Bean 名称
     * @return 处理过的 Bean
     * @throws BeansException 异常
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
