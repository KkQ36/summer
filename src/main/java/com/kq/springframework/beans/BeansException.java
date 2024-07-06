package com.kq.springframework.beans;

/**
 * @author kq
 * 2024-07-06 19:33
 *
 * 定义 Bean 异常
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
