package edu.zut.cs.software.sun.admin.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.sun.admin.domain.Role;

public class RoleDaoTest extends GenericDaoTestCase<Long, Role, RoleDao> {
	/**
	 * Logger for this class
	 */

	@Autowired
	RoleDao roleDao;

	@Test
	public void test() {
		Role r = new Role();
		r.setName("test_role");
		Role test_role = this.roleDao.save(r);
		Long role_id = test_role.getId();
		Role result = this.roleDao.getOne(role_id);
		assertEquals(test_role, result);
		List<Role> all = this.roleDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Role> all size ={}", all.size()); //$NON-NLS-1$
		}
	}

}
