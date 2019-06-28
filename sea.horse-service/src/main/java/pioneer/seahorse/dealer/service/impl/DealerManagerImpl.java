package pioneer.seahorse.dealer.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.dealer.dao.DealerDao;
import pioneer.seahorse.dealer.domain.Dealer;
import pioneer.seahorse.dealer.domain.Market;
import pioneer.seahorse.dealer.service.DealerManager;
import pioneer.seahorse.dealer.service.MarketManager;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author 白疆银
 * @Date  2019/4/28 14:34
 *
 */
@Service("dealerManager")

public class DealerManagerImpl extends GenericManagerImpl<Dealer, Long> implements DealerManager {
    DealerDao dealerDao;
    MarketManager marketManager;

    @Autowired
    public void setDealerDao(DealerDao dealerDao) {
        this.dealerDao = dealerDao;
        this.dao = this.dealerDao;
    }

    @Autowired
    public void setMarketManager(MarketManager  marketManager) {this.marketManager = marketManager; }



    @Override
    public List<Dealer> getAll() {
        this.marketManager.updata();
        List<Dealer> result = this.dao.findAll();
        return result;
    }

    @Override
    public Dealer findbyDealerId(Long id) {
        Dealer dealer = null;
        List<Dealer> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                dealer=all.get(i);
        }
        return dealer;
    }

    @Override
    public Dealer findbyDealerName(String name) {
        Dealer dealer = null;
        List<Dealer> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getName().equals(name))
                dealer=all.get(i);
        }
        return dealer;
    }

    @Override
    public Boolean deletebyDealerId(Long id) {
        Optional<Dealer> stuList=this.dao.findById(id);
        if(stuList.equals(null)) {
            return false;
        } else {
            this.dao.delete(stuList.get());
            return true;
        }
    }
    @Override
    public Boolean deleteDealer( Long id){
        Dealer dealer=this.findbyDealerId(id);
        Market market=this.marketManager.findbyMarketName(dealer.getMarket().getName());
        Boolean bool=this.deletebyDealerId(id);
        Iterator<Dealer> it = market.getDealers().iterator();
        while (it.hasNext()) {
            Dealer str = it.next();
            if (dealer.getId().equals(str.getId())) {
                it.remove();
            }
        }
        this.marketManager.reduce(market);
        return bool;
    }
    @Override
    public Dealer addDealer( Dealer dealer){
        Market market=this.marketManager.findbyMarketName(dealer.getMarket().getName());
        dealer.setMarket(market);
        this.save(dealer);
        market.getDealers().add(dealer);
        this.marketManager.reduce(market);
        return dealer;
    }
    @Override
    public Dealer updateDealer( Dealer dealer){
        Market market=this.marketManager.findbyMarketName(dealer.getMarket().getName());
        Dealer de=this.findbyDealerId(dealer.getId());
        de.setName(dealer.getName());
        de.setNum(dealer.getNum());
        de.setAddress(dealer.getAddress());
        de.setContact(dealer.getContact());
        de.setMarket(market);
        de.setDateModified(new Date());
        this.save(de);
        market.getDealers().add(de);
        return dealer;
    }

}