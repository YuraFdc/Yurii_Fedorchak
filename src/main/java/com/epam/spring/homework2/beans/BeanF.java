package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

//@Component
public class BeanF implements MyValidator{
    private String name;
    private int value;

    public BeanF(){
        System.out.println(System.lineSeparator() + "BeanF initialized");
    }

    @Override
    public String toString() {
        return "BeanF{" +
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
}
