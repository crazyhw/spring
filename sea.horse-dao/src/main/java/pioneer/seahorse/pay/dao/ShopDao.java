package pioneer.seahorse.pay.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.pay.domain.Shop;

/**
 * @author lvqingyv
 * @date 2019/6/21 19:23
 */
@Repository("shopDao")
public interface ShopDao extends GenericTreeDao<Shop, Long> {

}