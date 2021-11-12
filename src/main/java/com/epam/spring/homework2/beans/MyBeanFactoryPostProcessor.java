package com.epam.spring.homework2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("Inside postProcessBeanFactory method");
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("beanB");
        beanDefinition.setInitMethodName("newCustomInitMethod");
        System.out.println("initMethod name \"customInitBeanB\" was changed to \" newCustomInitMethod\"");
    }
}
