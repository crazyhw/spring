package com.edu.zutt.cs.software;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
                                               //生目标代理类
public class usemangdaili implements InvocationHandler {
	private Object proxyObj;                   //定义代理对象
	   
	    
	      // Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
	      //loader    :类加载器 一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
	      // interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
	      // h:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
	     
	  public Object newProxy(Object proxyObj){    //返回一个代理对象  
	       this.proxyObj = proxyObj;
	                                      
return Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(),   proxyObj.getClass().getInterfaces(),   this);  
	       }  

	    
	       // 执行目标对象
	       /* Object  proxy：被代理的对象
	        Method  method：要调用的方法
	        Object  args[]：方法调用时所需要的参数
	       */
	        public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {      
	             before();
	             Object object = method.invoke(this.proxyObj,args);  // 通过反射机制调用目标对象的方法
	                                                                 //生成invocationhandler管理对象
	             after();      
	             return object;  
	         }
	    
	         public void before(){
	              System.out.println("开始执行目标对象之前...");
	         }
	    
	         public void after(){
	             System.out.println("开始执行目标对象之后...");
	         }

			
			
	     


}
