package com.kq.springframework.beans.factory;

/**
 * @author kq
 * 2024-08-29 19:44
 * 使得Bean可以感知到ClassLoader，以后的 ClassLoader 会使用此方法设置过的 ClassLoader 来加载类
 **/
public interface BeanClassLoaderAware {

    void setBeanClassLoader(ClassLoader classLoader);

}
