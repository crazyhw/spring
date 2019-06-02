package pioneer.seahorse.trade_merchant.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import pioneer.seahorse.trade_merchant.domain.Merchant;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author 于靖鑫
 *
 */
public class MerchantDaoTest extends GenericTreeDaoTestCase<Long, Merchant, MerchantDao> {

    private static final Logger logger = LogManager.getLogger(MerchantDaoTest.class.getName());

    MerchantDao merchantDao;

    @Autowired
    public void setMerchantDao(MerchantDao merchantDao) {
        this.merchantDao = merchantDao;
        this.dao = this.merchantDao;
    }

    @Test
    public void testGetRoot() {
        int root_size = 3;
        for(int i = 0; i < root_size; i++) {
            Merchant merchant = new Merchant();
            merchant.setName("merchant_" + i);
            for(int j = 0; j < 3; j++) {
                Merchant s = new Merchant();
                s.setName("merchant_" + i + "_" + j);
                s.setParent(merchant);
            }
            this.merchantDao.save(merchant);
        }

        List<Merchant> roots = this.merchantDao.getRoot();
        assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Merchant> roots={}", roots); //$NON-NLS-1$
        }
    }

}

