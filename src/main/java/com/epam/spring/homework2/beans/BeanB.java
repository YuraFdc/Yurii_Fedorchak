package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

//@Component
public class BeanB implements MyValidator{
    private String name;
    private int value;

    public BeanB(String name, int value){
        this.name = name;
        this.value = value;
        System.out.println(System.lineSeparator() + "BeanB initialized");
    }

    @Override
    public String toString() {
        return "BeanB{" +
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

    private void customInitBeanB() {
        System.out.println("Inside customInitBeanB() method");
    }

    private void customDestroyBeanB() {
        System.out.println("Inside customDestroyBeanB() method");
    }
}
