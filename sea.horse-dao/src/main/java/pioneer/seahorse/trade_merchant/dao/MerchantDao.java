package pioneer.seahorse.trade_merchant.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.trade_merchant.domain.Merchant;
/**
 * MerchantDao
 * @author 于靖鑫
 * @Date  2019/4/7 18:10
 */
@Repository("merchantDao")
public interface MerchantDao extends GenericTreeDao<Merchant, Long> {

}
