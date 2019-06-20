package pioneer.seahorse.goods.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import pioneer.seahorse.goods.domain.Management;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Management测试
 * @author 李培磊
 * @Date  2019/4/18 14:45
 */
public class ManagementDaoTest extends GenericTreeDaoTestCase<Long, Management, ManagementDao> {

    private static final Logger logger = LogManager.getLogger(ManagementDaoTest.class.getName());

    ManagementDao ManagementDao;

    @Autowired
    public void setManagementDao(ManagementDao ManagementDao) {
        this.ManagementDao = ManagementDao;
        this.dao = this.ManagementDao;
    }

    @Test
    public void testGetRoot() {
        int root_size = 3;
        for(int i = 0; i < root_size; i++) {
            Management management = new Management();
            management.setName("management_" + i);
            for(int j = 0; j < 3; j++) {
                Management s = new Management();
                s.setName("management_" + i + "_" + j);
                s.setParent(management);
            }
            this.ManagementDao.save(management);
        }

        List<Management> roots = this.ManagementDao.getRoot();
        assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Management> roots={}", roots); //$NON-NLS-1$
        }


    }

}

