package com.zut.edu.cs.software;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.edu.zut.cs.software.Usemange;
public class Usemangetst {
   @Autowired
    //private Usemange user;

    public Usemange getUser(Usemange user) {
           return user;
    }
	
    @Test
    public void say(){
       String xmlpath = " com/edu/zut/cs/software/applict.xml";
       ApplicationContext context = new ClassPathXmlApplicationContext(xmlpath);
      Usemange bean = (Usemange) context.getBean("usemange");
      bean.toString();
     
       // bean.getString();

    }
}
