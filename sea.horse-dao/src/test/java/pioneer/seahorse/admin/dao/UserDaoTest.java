package pioneer.seahorse.admin.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.admin.domain.User;
import pioneer.seahorse.base.dao.GenericDaoTestCase;

import java.util.List;

public class UserDaoTest extends GenericDaoTestCase<Long, User, UserDao> {

	private static final Logger logger = LogManager.getLogger(UserDaoTest.class.getName());
	
	@Autowired
    UserDao userDao;
	
	@Test
	public void testFindAll() {
		
		List<User> all = this.userDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<User> all={}", all); //$NON-NLS-1$
		}
		
		
	}
	
}
