package com.kq.springframework.util;

/**
 * @author kq
 * 2024-08-27 20:46
 **/
public class ClassUtils {

    /**
     * 获取默认的 ClassLoader
     * @return ClassLoader
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ex) {
            // 无法获取到线程的 ClassLoader，退回去获取系统 ClassLoader
        }
        if (cl == null) {
            // 没有线程的 ClassLoader，使用当前类的 ClassLoader
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

}
