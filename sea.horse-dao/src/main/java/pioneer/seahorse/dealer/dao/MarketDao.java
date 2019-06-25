package pioneer.seahorse.dealer.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.dealer.domain.Market;
/**
 * MarketDao
 * @author 白疆银
 * @Date  2019/3/24 13:28
 */
@Repository("marketDao")
public interface MarketDao extends GenericTreeDao<Market, Long> {

}
