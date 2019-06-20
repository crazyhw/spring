package pioneer.seahorse.dealer.dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;

import pioneer.seahorse.dealer.domain.Dealer;

import java.util.List;

/**
 * Dealer测试
 * @author 白疆银
 * @Date  2019/4/13 09:32
 */
public class DealerDaoTest extends GenericDaoTestCase<Long, Dealer, DealerDao> {
    private static final Logger logger = LogManager.getLogger(DealerDaoTest.class.getName());
    @Autowired
    DealerDao dealerDao;

    @Test
    public void testFindAll() {

        List<Dealer> all = this.dealerDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Dealer> all={}", all); //$NON-NLS-1$
        }
    }
}
