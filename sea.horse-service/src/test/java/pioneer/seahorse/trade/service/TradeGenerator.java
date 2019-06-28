package pioneer.seahorse.trade.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.trade.dao.TradeDao;

/**
 * TradeGeneric 类
 *
 * @author 于靖鑫
 * @date 2019/6/3 17:43
 */
public class TradeGenerator extends GenericGenerator {

    private static final Logger logger = LogManager.getLogger(pioneer.seahorse.trade.service.TradeGenerator.class.getName());

    @Autowired
    TradeDao tradeDao;

    @Test
    public void AddTrade()
    {
    }
}