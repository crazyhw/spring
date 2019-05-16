package edu.zut.cs.software.sun.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.sun.admin.dao.UserDao;
import edu.zut.cs.software.sun.admin.domain.User;
import edu.zut.cs.software.sun.admin.service.UserManager;

@Service("userManager")
public class UserManagerImpl extends GenericManagerImpl<User, Long> implements UserManager {

	
	UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		this.dao = this.userDao;
	}

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
		List<User> all = this.userDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("getAll() - List<User> all={}", all); //$NON-NLS-1$
		}
		return all;
	}

}
