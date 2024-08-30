package com.kq.springframework.content.support;

import com.kq.springframework.beans.BeansException;

/**
 * @author kq
 * 2024-08-28 20:28
 * 应用上下文实现类，定义了获取配置的方法
 **/
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {}

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocation 资源位置
     * @throws BeansException 异常
     */
    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations 资源位置数组
     * @throws BeansException 异常
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

}
