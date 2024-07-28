package com.kq.springframework.beans;

/**
 * @author kq
 * 2024-07-07 13:03
 * bean 属性信息
 **/
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
