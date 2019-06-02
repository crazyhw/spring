package pioneer.seahorse.dealer.service;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;
import pioneer.seahorse.dealer.domain.Market;

import java.util.List;


public class MarketManagerTest extends GenericTreeManagerTestCase<Long, Market, MarketManager>  {
    MarketManager marketManager;

    public MarketManagerTest() {
        super(Market.class);
    }

    @Autowired
    public void setMarketManager(MarketManager marketManager) {
        this.marketManager = marketManager;
        this.manager = this.marketManager;
    }

    @Test
    public void testGetAll() {
        List<Market> all = this.marketManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Market> all={}", all); //$NON-NLS-1$
        }
    }
}
