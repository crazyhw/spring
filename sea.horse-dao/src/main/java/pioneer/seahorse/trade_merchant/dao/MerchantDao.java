package pioneer.seahorse.trade_merchant.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.trade_merchant.domain.Merchant;

@Repository("merchantDao")
public interface MerchantDao extends GenericTreeDao<Merchant, Long> {

}
