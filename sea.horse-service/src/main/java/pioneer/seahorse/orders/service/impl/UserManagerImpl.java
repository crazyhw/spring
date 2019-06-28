package pioneer.seahorse.orders.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;
import pioneer.seahorse.order.damain.User;
import pioneer.seahorse.order.dao.UserDao;
import pioneer.seahorse.orders.service.UserManager;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * UserManagerImpl 类
 *
 * @author 张国伟
 * @date 2019/6/27 16:06
 */
@Service(value = "userManager")
public class UserManagerImpl extends GenericTreeManagerImpl<User, Long> implements UserManager {
    UserDao userDao;

    @Autowired
    public void setUserDaoDao(UserDao userDao) {
        this.userDao = userDao;
        this.treeDao = this.userDao;
        this.dao = this.treeDao;
    }

    @Override
    public List<User> getAll() {
        List<User> all = this.userDao.findAll();
        return all;
    }

    @Override
    public User addUser( User user){
        this.save(user);
        return user;
    }

    @Override
    public User findbyUserId(Long id) {
        User user = null;
        List<User> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                user=all.get(i);
        }
        return user;
    }

    @Override
    public User findbyUserName(String name) {
        User user = new User();
        List<User> all = this.dao.findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getName().equals(name))
                user = all.get(i);
        }
        return user;
    }

    @Override
    public Boolean deletebyUserId(Long id) {
        Optional<User> stuList=this.dao.findById(id);
        if(stuList.equals(null)) {
            return false;
        } else {
            this.dao.delete(stuList.get());
            return true;
        }
    }

    @Override
    public User UpdataUser(User user){
        User del=this.findbyUserId(user.getId());
        del.setName(user.getName());
        del.setAddress(user.getAddress());
        del.setContact(user.getContact());
        del.setOrders(user.getOrders());
        del.setDateModified(new Date());
        this.save(del);
        return user;
    }

}
