package pioneer.seahorse.admin.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.admin.domain.User;
import pioneer.seahorse.base.service.GenericManagerTestCase;

public class UserManagerTest extends GenericManagerTestCase<Long, User, UserManager> {

    private static final Logger logger = LogManager.getLogger(UserManagerTest.class.getName());

    UserManager userManager;

    public UserManagerTest() {
        super(User.class);
    }

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Test
    public void testGetAll() {
        List<User> all = this.userManager.getAll();
        assertNotNull(all);
//		assertEquals(100, all.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<User> all={}", all); //$NON-NLS-1$
        }
    }

    @Test
    public void testSayHello() {
        String expected = "Hello, world!";
        String result = this.userManager.sayHello("world");
        if (logger.isInfoEnabled()) {
            logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
        }

        assertEquals(expected, result);
    }
}

