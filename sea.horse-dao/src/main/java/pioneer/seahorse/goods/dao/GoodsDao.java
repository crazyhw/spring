package pioneer.seahorse.goods.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.goods.domain.Goods;

@Repository("GoodsDao")
public interface GoodsDao extends GenericDao<Goods, Long> {

}
