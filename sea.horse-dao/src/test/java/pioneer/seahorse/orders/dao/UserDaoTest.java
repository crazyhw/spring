package pioneer.seahorse.orders.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import pioneer.seahorse.order.damain.User;
import pioneer.seahorse.order.dao.UserDao;

import java.util.List;

/**
 * UserDaoTest 类
 *
 * @author 张国伟
 * @date 2019/6/27 16:01
 */
public class UserDaoTest extends GenericTreeDaoTestCase<Long, User, UserDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(UserDaoTest.class.getName());

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        this.dao = this.userDao;
    }

    @Test
    public void testGetRoot() {
        List<User> roots = this.userDao.getRoot();
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<User> roots={}", roots); //$NON-NLS-1$
        }


    }

}
