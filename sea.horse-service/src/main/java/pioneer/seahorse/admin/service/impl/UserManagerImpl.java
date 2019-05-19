package pioneer.seahorse.admin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pioneer.seahorse.admin.dao.UserDao;
import pioneer.seahorse.admin.domain.User;
import pioneer.seahorse.admin.service.UserManager;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import java.util.List;

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
        return result;
    }

    @Override
    public List<User> getAll() {
        List<User> all = this.userDao.findAll();
        return all;
    }

}

