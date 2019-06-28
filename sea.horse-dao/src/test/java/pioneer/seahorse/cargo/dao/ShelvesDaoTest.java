package pioneer.seahorse.shelves.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import pioneer.seahorse.cargo.dao.ShelvesDao;
import pioneer.seahorse.cargo.domain.Shelves;
import java.util.List;

/**
 * ShelvesDaoTest 类
 *
 * @author 任鑫意
 * @date 2019/6/20 17:17
 */
public class ShelvesDaoTest extends GenericTreeDaoTestCase<Long, Shelves, ShelvesDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(ShelvesDaoTest.class.getName());

    ShelvesDao shelvesDao;

    @Autowired
    public void setShelvesDao(ShelvesDao shelvesDao) {
        this.shelvesDao = shelvesDao;
        this.dao = this.shelvesDao;
    }

    @Test
    public void testGetRoot() {
        List<Shelves> roots = this.shelvesDao.getRoot();
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Shelves> roots={}", roots); //$NON-NLS-1$
        }


    }

}
