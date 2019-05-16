package edu.zut.cs.software.sun.admin.service;

import java.util.List;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.sun.admin.domain.User;

public interface UserManager extends GenericManager<User,Long> {

	String sayHello(String name);

	List<User> getAll();
}
