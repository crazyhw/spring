package pioneer.seahorse.dealer.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.dealer.domain.Market;

@Repository("marketDao")
public interface MarketDao extends GenericTreeDao<Market, Long> {

}
