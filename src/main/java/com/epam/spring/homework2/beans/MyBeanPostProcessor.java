package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Inside " + MyBeanPostProcessor.class.getSimpleName() + " BeforeInitialization"
                + " for " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Inside " + MyBeanPostProcessor.class.getSimpleName() + " AfterInitialization"
                + " for " + beanName);
        if (bean instanceof MyValidator) {
            ((MyValidator) bean).validate();
        }
        return bean;
    }
}
