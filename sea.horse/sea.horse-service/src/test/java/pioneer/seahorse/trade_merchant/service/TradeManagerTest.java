package pioneer.seahorse.trade_merchant.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.trade_merchant.domain.Trade;
import java.util.List;
/**
 *
 * @author 于靖鑫
 * @Date  2019/5/26 13:15
 *
 */
public class TradeManagerTest extends GenericManagerTestCase<Long, Trade, TradeManager> {

    private static final Logger logger = LogManager.getLogger(TradeManagerTest.class.getName());

    TradeManager tradeManager;

    public TradeManagerTest() {
        super(Trade.class);
    }

    @Autowired
    public void setTradeManager(TradeManager tradeManager) {
        this.tradeManager = tradeManager;
    }

    @Test
    public void testGetAll() {
        List<Trade> all = this.tradeManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Trade> all={}", all); //$NON-NLS-1$
        }
    }

}