package pioneer.seahorse.dealer.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;

import pioneer.seahorse.dealer.dao.DealerDao;
import pioneer.seahorse.dealer.domain.Dealer;
import pioneer.seahorse.dealer.service.DealerManager;

import java.util.List;

@Service("dealerManager")

public class DealerManagerImpl extends GenericManagerImpl<Dealer, Long> implements DealerManager {
    DealerDao dealerDao;

    @Autowired
    public void setDealerDao(DealerDao dealerDao) {
        this.dealerDao = dealerDao;
        this.dao = this.dealerDao;
    }


    @Override
    public List<Dealer> getAll() {
        List<Dealer> all = this.dealerDao.findAll();
        return all;
    }
}
