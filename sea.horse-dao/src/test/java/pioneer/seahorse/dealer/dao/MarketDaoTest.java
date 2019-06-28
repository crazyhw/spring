package pioneer.seahorse.dealer.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import pioneer.seahorse.dealer.domain.Market;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Market测试
 * @author 白疆银
 * @Date  2019/4/13 09:32
 */
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
        List<Market> roots = this.marketDao.getRoot();
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Market> roots={}", roots); //$NON-NLS-1$
        }


    }

}
