package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

//@Component
public class BeanD implements MyValidator{
    private String name;
    private int value;

    public BeanD(String name, int value) {
        this.name = name;
        this.value = value;
        System.out.println(System.lineSeparator() + "BeanD initialized");
    }

    @Override
    public String toString() {
        return "BeanD{" +
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

    private void customInitBeanD() {
        System.out.println("Inside customInitBeanD() method");
    }

    private void customDestroyBeanD() {
        System.out.println("Inside customDestroyBeanD() method");
    }
}
