package pioneer.seahorse.trade.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.trade.domain.Trade;
/**
 * TradeDao
 * @author 于靖鑫
 * @Date  2019/3/24 13:28
 */
@Repository("tradeDao")
public interface TradeDao extends GenericDao<Trade, Long> {
}