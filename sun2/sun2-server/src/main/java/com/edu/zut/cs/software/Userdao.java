package com.edu.zut.cs.software;

import org.springframework.stereotype.Repository;
                                  //���巺�͸��༴bean��־û�
 @Repository("user")
public abstract class Userdao <T> {

	public void say (T t)
	{
		System.out.print("����һ������");
	}
}
