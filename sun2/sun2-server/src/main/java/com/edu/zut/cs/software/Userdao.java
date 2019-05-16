package com.edu.zut.cs.software;

import org.springframework.stereotype.Repository;
                                  //定义泛型父类即bean层持久化
 @Repository("user")
public abstract class Userdao <T> {

	public void say (T t)
	{
		System.out.print("这是一个泛型");
	}
}
