package com.edu.zutt.cs.software;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class usemangdailiTest {

	@Test
	public void testusemangedaili(){
        
        //我们要代理的真实对象
        Use testService = new Usemange();       
        //testJDKProxyService.add();//不是用代理   
        //生成代理类的对象
        usemangdaili JDKDynamicProxyTarget = new usemangdaili();
        //建立代理类和目标类的练习
        Use testServiceProxy = (Use) JDKDynamicProxyTarget.newProxy(testService);
       //执行代理类的方法  
      
       
           testServiceProxy.add();

   }
}
