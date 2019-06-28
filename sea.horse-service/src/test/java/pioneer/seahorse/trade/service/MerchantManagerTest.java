package pioneer.seahorse.trade.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.trade.domain.Merchant;

import java.util.List;

/**
 *
 * @author 于靖鑫
 * @Date  2019/5/28 20:26
 *
 */
public class MerchantManagerTest extends GenericManagerTestCase<Long, Merchant, MerchantManager> {

    private static final Logger logger = LogManager.getLogger(pioneer.seahorse.trade.service.MerchantManagerTest.class.getName());

    MerchantManager merchantManager;

    public MerchantManagerTest() {
        super(Merchant.class);
    }

    @Autowired
    public void setMerchantManager(MerchantManager merchantManager) {
        this.merchantManager = merchantManager;
        this.manager = this.merchantManager;
    }

    @Test
    public void testGetAll() {
        List<Merchant> all = this.merchantManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Merchant> all={}", all); //$NON-NLS-1$
        }
    }

}
