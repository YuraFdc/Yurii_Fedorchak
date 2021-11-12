package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

//@Component
public class BeanC implements MyValidator{
    private String name;
    private int value;

    public BeanC(String name, int value) {
        this.name = name;
        this.value = value;
        System.out.println(System.lineSeparator() + "BeanC initialized");
    }

    @Override
    public String toString() {
        return "BeanC{" +
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

    private void customInitBeanC() {
        System.out.println("Inside customInitBeanC() method");
    }

    private void customDestroyBeanC() {
        System.out.println("Inside customDestroyBeanC() method");
    }
}
