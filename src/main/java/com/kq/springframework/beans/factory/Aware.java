package com.kq.springframework.beans.factory;

/**
 * @author kq
 * 2024-08-29 19:39
 * 标记类接口，实现该接口可以被Spring容器感知，通过实现这个接口，可以实现 Bean 对象对ApplicationContext、BeanFactory、Environment、MessageSource
 * ResourceLoader、ApplicationEventPublisher 等内容的感知
 **/
public interface Aware { }