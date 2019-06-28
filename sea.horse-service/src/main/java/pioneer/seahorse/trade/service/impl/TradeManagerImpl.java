package pioneer.seahorse.trade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.trade.dao.TradeDao;
import pioneer.seahorse.trade.domain.Trade;
import pioneer.seahorse.trade.service.TradeManager;

import java.util.Date;
import java.util.List;
import java.util.Optional;


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
        List<Trade> result = this.dao.findAll();
        return result;
    }

    @Override
    public Trade findbyTradeName(String name) {
        Trade trade = null;
        List<Trade> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
            if (all.get(i).getName().equals(name))
                trade=all.get(i);
        return trade;
    }

    @Override
    public Trade findbyTradeId(Long id) {
        Trade trade = null;
        List<Trade> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                trade=all.get(i);
        }
        return trade;
    }

    @Override
    public Boolean deletebyTradeId(Long id) {
        Optional<Trade> traList=this.dao.findById(id);
        if(traList.equals(null)) {
            return false;
        } else {
            this.dao.delete(traList.get());
            return true;
        }
    }

    @Override
    public Trade updateTrade(Trade trade){
        Trade tra=this.findbyTradeId(trade.getId());
        tra.setNum(trade.getNum());
        tra.setName(trade.getName());
        tra.setMarks(trade.getMarks());
        tra.setDateModified(new Date());
        this.save(tra);
        return trade;
    }

}
