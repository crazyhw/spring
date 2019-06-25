package pioneer.seahorse.dealer.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;
import pioneer.seahorse.dealer.dao.MarketDao;
import pioneer.seahorse.dealer.domain.Market;
import pioneer.seahorse.dealer.service.MarketManager;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author 白疆银
 * @Date  2019/4/28 14:34
 *
 */
@Service(value = "marketManager")

public class MarketManagerImpl extends GenericTreeManagerImpl<Market, Long> implements MarketManager {
    MarketDao marketDao;

    @Autowired
    public void setMarketDao(MarketDao marketDao) {
        this.marketDao = marketDao;
        this.treeDao = this.marketDao;
        this.dao = this.treeDao;
    }
    @Override
    public List<Market> getAll() {
        List<Market> result = this.dao.findAll();
        return result;
    }


    @Override
    public Market findbyMarketId(Long id) {
        Market market = null;
        List<Market> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                market=all.get(i);
        }
        return market;
    }

    @Override
    public Market findbyMarketName(String name) {
        Market market = null;
        List<Market> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getName().equals(name))
                market=all.get(i);
        }
        return market;
    }
    @Override
    public Boolean deletebyMarketId(Long id) {
        Optional<Market> stuList=this.dao.findById(id);
        if(stuList.equals(null)) {
            return false;
        } else {
            this.dao.delete(stuList.get());
            return true;
        }
    }
    @Override
    public void reduce(Market market){
        int x=market.getDealers().size();
        market.setNumber(x);
        market.setDateModified(new Date());
        this.dao.save(market);
    }

    @Override
    public void updata(){
        List<Market> markets=this.dao.findAll();
        for (int i=0;i<markets.size();i++)
            this.reduce(markets.get(i));
    }
    @Override
    public Boolean addMarket( Market market) {
        market.setNumber(0);
        this.save(market);
        return true;
    }
    @Override
    public Boolean updateMarket( Market market) {
        Market ma = this.findbyMarketId(market.getId());
        ma.setName(market.getName());
        ma.setAddress(market.getAddress());
        ma.setNumber(market.getNumber());
        ma.setDealers(market.getDealers());
        ma.setDateModified(new Date());
        this.save(ma);
        return true;
    }

}
