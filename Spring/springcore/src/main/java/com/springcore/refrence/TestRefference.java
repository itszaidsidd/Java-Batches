package com.springcore.refrence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRefference {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/refrence/refrenceConfig.xml");
        B b = (B) context.getBean("bref");
        System.out.println(b);

        A a = (A) context.getBean("aref");
        System.out.println(a);

    }

}
