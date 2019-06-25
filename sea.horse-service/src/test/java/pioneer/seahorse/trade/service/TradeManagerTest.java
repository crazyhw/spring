package pioneer.seahorse.trade.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.trade.domain.Trade;

import java.util.List;

/**
 *
 * @author 于靖鑫
 * @Date  2019/5/28 20:26
 *
 */
public class TradeManagerTest extends GenericManagerTestCase<Long, Trade, TradeManager> {

    private static final Logger logger = LogManager.getLogger(pioneer.seahorse.trade.service.TradeManagerTest.class.getName());

    TradeManager tradeManager;

    public TradeManagerTest() {
        super(Trade.class);
    }

    @Autowired
    public void setTradeManager(TradeManager tradeManager) {
        this.tradeManager = tradeManager;
        this.manager = this.tradeManager;
    }

    @Test
    public void testGetAll() {
        List<Trade> all = this.tradeManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Trade> all={}", all); //$NON-NLS-1$
        }
    }

}
