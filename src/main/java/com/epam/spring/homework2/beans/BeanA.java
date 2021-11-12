package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//@Component
public class BeanA implements MyValidator, InitializingBean, DisposableBean {
    private String name;
    private int value;

    public BeanA(){
        System.out.println(System.lineSeparator() + "BeanA initialized");
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void validate() {
        System.out.println("Inside validate method of " + this.getClass().getSimpleName());
        if(name == null || value < 1){
            System.out.println(this.getClass().getSimpleName() + " is not valid");
        } else {
            System.out.println(this.getClass().getSimpleName() + " is valid");
        }
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Inside DisposableBean.destroy() method of BeanA");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Inside InitializingBean.afterPropertiesSet() method of BeanA");
    }
}
