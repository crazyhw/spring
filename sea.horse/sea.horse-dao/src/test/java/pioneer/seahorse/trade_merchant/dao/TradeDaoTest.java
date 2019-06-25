package pioneer.seahorse.trade_merchant.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.trade_merchant.domain.Trade;

import java.util.List;

/**
 * Trade测试
 * @author 于靖鑫
 * @Date  2019/4/22 15:33
 */
public class TradeDaoTest extends GenericDaoTestCase<Long, Trade, TradeDao> {

    private static final Logger logger = LogManager.getLogger(TradeDaoTest.class.getName());
    @Autowired
    TradeDao tradeDao;

    @Test
    public void testFindAll() {

        List<Trade> all = this.tradeDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Trade> all={}", all); //$NON-NLS-1$
        }
    }
}
