package pioneer.seahorse.goods.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.goods.domain.Goods;
/**
 * GoodsDao
 * @author 李培磊
 * @Date  2019/4/3 15:20
 */
@Repository("GoodsDao")
public interface GoodsDao extends GenericDao<Goods, Long> {

}
