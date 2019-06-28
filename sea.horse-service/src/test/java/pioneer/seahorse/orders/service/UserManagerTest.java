package pioneer.seahorse.orders.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;
import pioneer.seahorse.order.damain.User;

import java.util.List;

/**
 * UserManagerTest 类
 *
 * @author 张国伟
 * @date 2019/6/27 16:15
 */
public class UserManagerTest extends GenericTreeManagerTestCase<Long, User, UserManager> {
    UserManager userManager;

    public UserManagerTest() {
        super(User.class);
    }

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
        this.manager = this.userManager;
    }

    @Test
    public void testGetAll() {
        List<User> all = this.userManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<User> all={}", all); //$NON-NLS-1$
        }
    }
}
