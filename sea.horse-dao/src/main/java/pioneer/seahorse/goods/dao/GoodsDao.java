package pioneer.seahorse.goods.dao;
import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.goods.domain.Goods;
/**
 * DealerDao
 * @author lpl
 * @Date  2019/3/24 13:28
 */
@Repository("goodsDao")
public interface GoodsDao extends GenericDao<Goods, Long>{
}
