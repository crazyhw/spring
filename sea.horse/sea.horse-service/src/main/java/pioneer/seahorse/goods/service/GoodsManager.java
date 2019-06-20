package pioneer.seahorse.goods.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.goods.domain.Goods;

import java.util.List;
/**
 *
 * @author 李培磊
 * @Date  2019/5/7 18:36
 *
 */
public interface GoodsManager extends GenericManager<Goods, Long> {

    String sayHello(String name);

    List<Goods> getAll();

}
