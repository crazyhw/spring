package pioneer.seahorse.trade_merchant.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.trade_merchant.domain.Trade;
import pioneer.seahorse.base.service.GenericManagerTestCase;

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
        assertNotNull(all);
//		assertEquals(100, all.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Trade> all={}", all); //$NON-NLS-1$
        }
    }

    @Test
    public void testSayHello() {
        String expected = "Hello, world!";
        String result = this.tradeManager.sayHello("world");
        if (logger.isInfoEnabled()) {
            logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
        }

        assertEquals(expected, result);
    }
}
