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
 * @author lpl
 * @Date  2019/4/13 09:32
 */
public class ManagementDaoTest  extends GenericTreeDaoTestCase<Long, Management, ManagementDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(ManagementDaoTest.class.getName());

    ManagementDao managementDao;

    @Autowired
    public void setManagementDao(ManagementDao managementDao) {
        this.managementDao = managementDao;
        this.dao = this.managementDao;
    }

    @Test
    public void testGetRoot() {
        int root_size = 3;
        for (int i = 0; i < root_size; i++) {
            Management management = new Management();
            management.setName("management_" + i);
            for (int j = 0; j < 3; j++) {
                Management s = new Management();
                s.setName("management_" + i + "_" + j);
                s.setParent(management);
            }
            this.managementDao.save(management);
        }

        List<Management> roots = this.managementDao.getRoot();
        //assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Management> roots={}", roots); //$NON-NLS-1$
        }
    }
}
