package pioneer.seahorse.dealer.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;
import pioneer.seahorse.dealer.dao.MarketDao;
import pioneer.seahorse.dealer.domain.Market;
import pioneer.seahorse.dealer.service.MarketManager;

import java.util.List;

@Service(value = "marketManager")

public class MarketManagerImpl extends GenericTreeManagerImpl<Market, Long> implements MarketManager {
    MarketDao marketDao;

    @Autowired
    public void setMarketDaoDao(MarketDao marketDao) {
        this.marketDao = marketDao;
        this.treeDao = this.marketDao;
        this.dao = this.treeDao;
    }

    @Override
    public List<Market> getAll() {
        List<Market> all = this.marketDao.findAll();
        return all;
    }
}
