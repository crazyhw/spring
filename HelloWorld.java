package com.edu.software.controller;

public class HelloWorld {
    public String name;

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.print("hello:" + name);
    }
}