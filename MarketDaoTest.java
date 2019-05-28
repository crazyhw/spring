package pioneer.seahorse.dealer.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import pioneer.seahorse.dealer.domain.Market;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class MarketDaoTest extends GenericTreeDaoTestCase<Long, Market, MarketDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(MarketDaoTest.class.getName());

    MarketDao marketDao;

    @Autowired
    public void setMarketDao(MarketDao marketDao) {
        this.marketDao = marketDao;
        this.dao = this.marketDao;
    }

    @Test
    public void testGetRoot() {
        int root_size = 10;
        for(int i = 0; i < root_size; i++) {
            Market market = new Market();
            market.setName("market_" + i);
            for(int j = 0; j < 10; j++) {
                Market s = new Market();
                s.setName("market_" + i + "_" + j);
                s.setParent(market);
            }
            this.marketDao.save(market);
        }

        List<Market> roots = this.marketDao.getRoot();
        assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Market> roots={}", roots); //$NON-NLS-1$
        }


    }

}
