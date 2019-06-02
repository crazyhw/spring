package pioneer.seahorse.distribution.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import pioneer.seahorse.distribution.domain.Deliveryclerk;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author 郭万江
 *
 */
public class DeliveryclerkDaoTest extends GenericTreeDaoTestCase<Long, Deliveryclerk, DeliveryclerkDao> {

    private static final Logger logger = LogManager.getLogger(DeliveryclerkDaoTest.class.getName());

    DeliveryclerkDao deliveryclerkDao;

    @Autowired
    public void setDeliveryclerkDao(DeliveryclerkDao deliveryclerkDao) {
        this.deliveryclerkDao = deliveryclerkDao;
        this.dao = this.deliveryclerkDao;
    }

    @Test
    public void testGetRoot() {
        int root_size = 3;
        for(int i = 0; i < root_size; i++) {
            Deliveryclerk deliveryclerk = new Deliveryclerk();
            deliveryclerk.setName("deliveryclerk_" + i);
            for(int j = 0; j < 3; j++) {
                Deliveryclerk s = new Deliveryclerk();
                s.setName("deliveryclerk_" + i + "_" + j);
                s.setParent(deliveryclerk);
            }
            this.deliveryclerkDao.save(deliveryclerk);
        }

        List<Deliveryclerk> roots = this.deliveryclerkDao.getRoot();
        assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Deliveryclerk> roots={}", roots); //$NON-NLS-1$
        }


    }

}

