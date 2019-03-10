package com.edu.software.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //HelloWord he = new HelloWord();

        //1.创建spring的ioc容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        //2.从ioc容器中获取bean实例
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
        helloWorld.hello();

    }
}
