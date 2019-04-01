package edu.zut.cs.software.sun.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.sun.admin.entity.User;
import edu.zut.cs.software.sun.admin.service.UserManager;

@Service("userManager")
public class UserManagerImpl implements UserManager {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(UserManagerImpl.class.getName());

	@Override
	public String sayHello(String name) {
		String result = "Hello, " + name + "!";
		if (logger.isInfoEnabled()) {
			logger.info("sayHello(String) - String result={}", result); //$NON-NLS-1$
		}

		return result;
	}

	@Override
	public List<User> getAll() {
		List<User> all = new ArrayList<User>();
		for(int i =0;i<100;i++) {
			User u = new User();
			u.setName("User_"+i);
			all.add(u);
		}
	
		if (logger.isInfoEnabled()) {
			logger.info("getAll() - List<User> all={}", all); //$NON-NLS-1$
		}
		return all;
	}

}
