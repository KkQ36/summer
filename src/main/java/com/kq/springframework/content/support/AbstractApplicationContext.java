package com.kq.springframework.content.support;

import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.kq.springframework.beans.factory.config.BeanPostProcessor;
import com.kq.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.kq.springframework.content.ConfigurableApplicationContext;
import com.kq.springframework.core.DefaultResourceLoader;

import java.util.Map;

/**
 * @author kq
 * 2024-08-28 19:56
 * 抽象 ApplicationContext
 **/
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();

        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor(Invoke factory processors registered as beans in the context.)
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 5. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 6. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }


    /**
     * 创建 BeanFactory，并加载 BeanDefinition
     * @throws BeansException 异常
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    /**
     * 获取当前上下文配置的 Bean 工厂
     * @return BeanFactory
     */
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 执行 BeanFactoryPostProcessor
     * @param beanFactory BeanFactory
     */
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * 注册 BeanPostProcessor
     * @param beanFactory BeanFactory
     */
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

}
