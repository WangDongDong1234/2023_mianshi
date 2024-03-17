package com.test;

import com.core.BeanPostProcessor;
import com.core.Component;

@Component
public class WangDongDongBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if(beanName.endsWith("userService")){
            System.out.println("userService初始化前");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if(beanName.endsWith("userService")){
            System.out.println("userService初始化后");
        }
        return bean;
    }
}
