package com.edu.zut.cs.software;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Usermangtst {

	public class Main {

	    public void main(String[] args) {
	    	String xmlpath = " com/zut/edu/cs/software/dao.xml";
	        ApplicationContext context = new ClassPathXmlApplicationContext(xmlpath);   //�������ļ����ص�������
	       Usermange bea = (Usermange) context.getBean("user");
                                 bea.say();     

	    }
	}
	}

	