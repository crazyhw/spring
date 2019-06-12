package pioneer.seahorse.trade_merchant.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;
import pioneer.seahorse.trade_merchant.domain.Merchant;

import java.util.List;
/**
 *
 * @author 于靖鑫
 * @Date  2019/5/26 13:15
 *
 */
public class MerchantManagerTest extends GenericTreeManagerTestCase<Long, Merchant, MerchantManager> {

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
