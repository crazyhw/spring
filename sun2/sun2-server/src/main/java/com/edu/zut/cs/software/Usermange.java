package com.edu.zut.cs.software;
import org.springframework.stereotype.Repository;
@Repository("user")

public class Usermange extends Userdao<User> {
	public User user;
	
	public void say ()
	{
		System.out.print("����һ������");
		System.out.print(user.number);
		
	}

}
