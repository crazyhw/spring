package com.edu.zut.cs.software;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("usemange")      //控制层 
@Service("usemange")          //服务层
public class Usemange implements Use {

	    private String name = "ddh";
	    
	    public String getName() {
	        return name;
	    }
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("这是一个简单的apo");

	}

}
