package com.core;

/**
 * 后置处理器
 */
public interface BeanPostProcessor {

    /**
     * 初始化前
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessBeforeInitialization(Object bean,String beanName);

    /**
     * 初始化后
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessAfterInitialization(Object bean,String beanName);
}
