package com.zut.edu.cs.software;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.edu.zut.cs.software.Usemange;
public class Usemangetst {
   @Autowired                                                                 //�Զ�ע��
    private Usemange user;
    
    public void getUser() {
	    
          System.out.println(user.toString());
    }
   
    @Test
    public void say(){
       String xmlpath = " com/edu/zut/cs/software/applict.xml";
       ApplicationContext context = new ClassPathXmlApplicationContext(xmlpath);   //�������ļ����ص�������
      Usemange bea = (Usemange) context.getBean("usemange");                       //��ȡbean
    
      bea.say();
     

    }
    
}
