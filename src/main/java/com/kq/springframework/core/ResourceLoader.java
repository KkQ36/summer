package com.kq.springframework.core;

/**
 * @author kq
 * 2024-08-27 20:49
 * 资源加载器
 **/
public interface ResourceLoader {

    /**
     * 类路径前缀
     */
    String  CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 加载 location 位置的资源，将其转化为 Resource 对象
     * @param location 资源位置
     * @return Resource 对象
     */
    Resource getResource(String location);

}