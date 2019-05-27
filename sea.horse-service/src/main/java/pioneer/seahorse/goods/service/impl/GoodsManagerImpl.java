package pioneer.seahorse.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.goods.dao.GoodsDao;
import pioneer.seahorse.goods.domain.Goods;
import pioneer.seahorse.goods.service.GoodsManager;

import java.util.List;

@Service("goodsManager")
public class GoodsManagerImpl extends GenericManagerImpl<Goods, Long> implements GoodsManager {


    GoodsDao goodsDao;

    @Autowired
    public void setCargoDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
        this.dao = this.goodsDao;
    }

    @Override
    public String sayHello(String name) {
        String result = "Hello, " + name + "!";
        return result;
    }

    @Override
    public List<Goods> getAll() {
        List<Goods> all = this.goodsDao.findAll();
        return all;
    }

}
