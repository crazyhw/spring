package pioneer.seahorse.trade.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.trade.domain.Merchant;
/**
 * MerchantDao
 * @author 于靖鑫
 * @Date  2019/3/24 13:28
 */
@Repository("merchantDao")
public interface MerchantDao extends GenericDao<Merchant, Long> {
}
