package pioneer.seahorse.trade.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.trade.domain.Trade;

import java.util.List;
/**
 * Trade测试
 *
 * @author 于靖鑫
 * @Date  2019/5/28 17:52
 */
public class TradeDaoTest extends GenericDaoTestCase<Long, Trade, TradeDao> {

    private static final Logger logger = LogManager.getLogger(pioneer.seahorse.trade.dao.TradeDaoTest.class.getName());
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
