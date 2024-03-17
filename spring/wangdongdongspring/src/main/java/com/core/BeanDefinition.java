package com.core;

/**
 * bean定义，次数指的是注解
 */
public class BeanDefinition {

    /**
     * 类(那个类上)
     */
    private Class clazz;

    /**
     * 作用域
     */
    private String scope;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
