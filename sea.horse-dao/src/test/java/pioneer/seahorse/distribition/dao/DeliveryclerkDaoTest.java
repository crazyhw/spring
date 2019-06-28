package pioneer.seahorse.distribition.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import pioneer.seahorse.distribition.domain.Deliveryclerk;

import java.util.List;

/**
 * Deliveryclerk 类
 *
 * @author 郭万江
 * @date 2019/6/27 14:53
 */
public class DeliveryclerkDaoTest extends GenericTreeDaoTestCase<Long, Deliveryclerk, DeliveryclerkDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(DeliveryclerkDaoTest.class.getName());

    DeliveryclerkDao deliveryclerkDao;

    @Autowired
    public void setDeliveryclerkDao(DeliveryclerkDao deliveryclerkDao) {
        this.deliveryclerkDao = deliveryclerkDao;
        this.dao = this.deliveryclerkDao;
    }

    @Test
    public void testGetRoot() {
        List<Deliveryclerk> roots = this.deliveryclerkDao.getRoot();
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Deliveryclerk> roots={}", roots); //$NON-NLS-1$
        }


    }

}
