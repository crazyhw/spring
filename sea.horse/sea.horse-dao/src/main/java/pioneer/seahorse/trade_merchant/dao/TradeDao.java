package pioneer.seahorse.trade_merchant.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.trade_merchant.domain.Trade;
/**
 * TradeDao
 * @author 于靖鑫
 * @Date  2019/4/7 18:10
 */
@Repository("tradeDao")
public interface TradeDao extends GenericDao<Trade, Long> {

}
