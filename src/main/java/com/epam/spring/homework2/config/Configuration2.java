package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("application.properties")
@ComponentScan("com.epam.spring.homework2.beans")
public class Configuration2 {

    @Bean
    public BeanA beanA(){
        return new BeanA();
    }

    @Bean (
            initMethod = "customInitBeanB",
            destroyMethod = "customDestroyBeanB"
    )
    @DependsOn("beanD")
    public BeanB beanB(@Value("${beanB.name}") String name, @Value("${beanB.value}") int value){
        return new BeanB(name, value);
    }

    @Bean (
            initMethod = "customInitBeanC",
            destroyMethod = "customDestroyBeanC"
    )
    @DependsOn("beanB")
    public BeanC beanC(@Value("${beanC.name}") String name, @Value("${beanC.value}") int value){
        return new BeanC(name, value);
    }

    @Bean (
            initMethod = "customInitBeanD",
            destroyMethod = "customDestroyBeanD"
    )
    public BeanD beanD(@Value("${beanD.name}") String name, @Value("${beanD.value}") int value){
        return new BeanD(name, value);
    }

    @Bean
    public BeanE beanE(){
        return new BeanE();
    }

    @Bean
    @Lazy
    public BeanF beanF(){
        return new BeanF();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
