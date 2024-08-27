package com.kq.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.kq.springframework.beans.BeansException;
import com.kq.springframework.beans.PropertyValue;
import com.kq.springframework.beans.PropertyValues;
import com.kq.springframework.beans.factory.config.BeanDefinition;
import com.kq.springframework.beans.factory.config.BeanReference;
import java.lang.reflect.Constructor;

/**
 * @author kq
 * 2024-07-06 19:49
 * 自动装配 Bean 工厂，封装了 Bean 实例化操作
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 给 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 根据配置的实例化属性来实例化 Bean
     * @param beanDefinition Bean 定义
     * @param beanName Bean 名称
     * @param args 构造函数参数
     * @return 实例化好的 Bean
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor<?> constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * 填充 Bean 对象的属性
     * @param beanName Bean Name
     * @param bean Bean 对象
     * @param beanDefinition BeanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            // 遍历 Bean 对象中需要填充的属性，并且为其填充配置配置好的属性，若属性是 BeanReference 类型，则获取 Bean 对象
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    /**
     * 获取实例化策略
     * @return 实例化策略
     */
    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    /**
     * 设置实例化策略
     * @param instantiationStrategy 实例化策略
     */
    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}