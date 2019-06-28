package pioneer.seahorse.goods.service;
import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.goods.domain.Goods;
import java.util.List;
/**
 *
 * @author lpl
 * @Date  2019/4/28 14:34
 *
 */
public interface GoodsManager  extends GenericManager<Goods, Long> {
    List<Goods> getAll();

    Goods findbyGoodsId(Long id);

    Boolean deletebyGoodsId(Long id);

    Goods findbyGoodsName(String name);
    Boolean deleteGoods( Long id);
    Goods addGoods( Goods goods);
    Goods updateGoods( Goods goods);
}
