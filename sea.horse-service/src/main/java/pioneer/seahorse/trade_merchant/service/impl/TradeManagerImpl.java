package pioneer.seahorse.trade_merchant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.trade_merchant.dao.TradeDao;
import pioneer.seahorse.trade_merchant.domain.Trade;
import pioneer.seahorse.trade_merchant.service.TradeManager;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;

import java.util.List;

@Service("tradeManager")
public class TradeManagerImpl extends GenericManagerImpl<Trade, Long> implements TradeManager {


    TradeDao tradeDao;

    @Autowired
    public void setTradeDao(TradeDao tradeDao) {
        this.tradeDao = tradeDao;
        this.dao = this.tradeDao;
    }



    @Override
    public List<Trade> getAll() {
        List<Trade> all = this.tradeDao.findAll();
        return all;
    }

}