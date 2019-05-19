package pioneer.seahorse.trade_merchant.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.trade_merchant.domain.Trade;

@Repository("tradeDao")
public interface TradeDao extends GenericDao<Trade, Long> {

}
