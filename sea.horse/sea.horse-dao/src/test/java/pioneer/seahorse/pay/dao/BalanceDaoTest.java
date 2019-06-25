package pioneer.seahorse.pay.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.pay.domain.Balance;

import java.util.List;
/**
 * Balance测试
 * @author 吕庆宇
 * @Date  2019/4/20 16:50
 */
public class BalanceDaoTest extends GenericDaoTestCase<Long, Balance, BalanceDao> {
    private static final Logger logger = LogManager.getLogger(BalanceDaoTest.class.getName());
    @Autowired
    BalanceDao balanceDao;

    @Test
    public void testFindAll() {

        List<Balance> all = this.balanceDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Balance> result={}", all); //$NON-NLS-1$
        }

    }

}
