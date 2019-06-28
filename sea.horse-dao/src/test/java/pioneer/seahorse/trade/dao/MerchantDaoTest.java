package pioneer.seahorse.trade.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.trade.domain.Merchant;

import java.util.List;
/**
 * Merchant测试
 *
 * @author 于靖鑫
 * @Date  2019/5/28 17:52
 */
public class MerchantDaoTest extends GenericDaoTestCase<Long, Merchant, MerchantDao> {

    private static final Logger logger = LogManager.getLogger(pioneer.seahorse.trade.dao.MerchantDaoTest.class.getName());
    @Autowired
    MerchantDao merchantDao;

    @Test
    public void testFindAll() {

        List<Merchant> all = this.merchantDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Merchant> all={}", all); //$NON-NLS-1$
        }
    }
}
