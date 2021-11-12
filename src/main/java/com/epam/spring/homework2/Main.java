package com.epam.spring.homework2;

import com.epam.spring.homework2.config.Configuration1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration1.class);
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(context.getBean(beanName));
        }

        context.close();
    }
}
