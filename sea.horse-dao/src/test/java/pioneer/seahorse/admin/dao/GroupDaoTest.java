package pioneer.seahorse.admin.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.admin.domain.Group;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GroupDaoTest extends GenericTreeDaoTestCase<Long, Group, GroupDao> {

	private static final Logger logger = LogManager.getLogger(GroupDaoTest.class.getName());

	GroupDao groupDao;
	
	@Autowired
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
		this.dao = this.groupDao;
	}
	
	@Test
	public void testGetRoot() {
		int root_size = 3;
		for(int i = 0; i < root_size; i++) {
			Group group = new Group();
			group.setName("group_" + i);
			for(int j = 0; j < 3; j++) {
				Group g = new Group();
				g.setName("group_" + i + "_" + j);
				g.setParent(group);
			}
			this.groupDao.save(group);
		}
		
		List<Group> roots = this.groupDao.getRoot();
		assertEquals(root_size, roots.size());
		
		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Group> roots={}", roots); //$NON-NLS-1$
		}
		
	}
}
