package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class BeanE implements MyValidator{
    private String name;
    private int value;

    public BeanE(){
        System.out.println(System.lineSeparator() + "BeanE initialized");
    }

    @Override
    public String toString() {
        return "BeanE{" +
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

    @PostConstruct
    public void postConstructMethod(){
        System.out.println("Inside postConstruct method of BeanE");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Inside preDestroy method of BeanE");
    }
}
