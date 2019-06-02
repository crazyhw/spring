package pioneer.seahorse.dealer.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.dealer.domain.Dealer;

import java.util.List;

public class DealerManagerTest extends GenericManagerTestCase<Long, Dealer, DealerManager>  {
    private static final Logger logger = LogManager.getLogger(DealerManagerTest.class.getName());

    DealerManager dealerManager;

    public DealerManagerTest() {
        super(Dealer.class);
    }

    @Autowired
    public void setDealerManager(DealerManager dealerManager) {
        this.dealerManager = dealerManager;
    }

    @Test
    public void testGetAll() {
        List<Dealer> all = this.dealerManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Dealer> all={}", all); //$NON-NLS-1$
        }
    }
}
