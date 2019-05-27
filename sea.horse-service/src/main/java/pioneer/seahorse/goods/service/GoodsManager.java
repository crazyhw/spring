package pioneer.seahorse.goods.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.goods.domain.Goods;

import java.util.List;

public interface GoodsManager extends GenericManager<Goods, Long> {

    String sayHello(String name);

    List<Goods> getAll();

}
