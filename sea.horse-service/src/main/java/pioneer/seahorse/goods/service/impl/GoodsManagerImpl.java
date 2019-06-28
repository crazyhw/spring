package pioneer.seahorse.goods.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;


import pioneer.seahorse.goods.dao.GoodsDao;
import pioneer.seahorse.goods.domain.Goods;
import pioneer.seahorse.goods.domain.Management;
import pioneer.seahorse.goods.service.GoodsManager;
import pioneer.seahorse.goods.service.ManagementManager;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author lpl
 * @Date  2019/4/28 14:34
 *
 */
@Service("goodsManager")

public class GoodsManagerImpl extends GenericManagerImpl<Goods, Long> implements GoodsManager{
    GoodsDao goodsDao;
    ManagementManager managementManager;

    @Autowired
    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
        this.dao = this.goodsDao;
    }

    @Autowired
    public void setManagementManager(ManagementManager  managementManager) {this.managementManager = managementManager; }



    @Override
    public List<Goods> getAll() {
        this.managementManager.updata();
        List<Goods> result = this.dao.findAll();
        return result;
    }

    @Override
    public Goods findbyGoodsId(Long id) {
        Goods goods = null;
        List<Goods> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                goods=all.get(i);
        }
        return goods;
    }

    @Override
    public Goods findbyGoodsName(String name) {
        Goods goods = null;
        List<Goods> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getName().equals(name))
                goods=all.get(i);
        }
        return goods;
    }

    @Override
    public Boolean deletebyGoodsId(Long id) {
        Optional<Goods> stuList=this.dao.findById(id);
        if(stuList.equals(null)) {
            return false;
        } else {
            this.dao.delete(stuList.get());
            return true;
        }
    }
    @Override
    public Boolean deleteGoods( Long id){
        Goods goods=this.findbyGoodsId(id);
        Management management=this.managementManager.findbyManagementName(goods.getManagement().getName());
        Boolean bool=this.deletebyGoodsId(id);
        Iterator<Goods> it = management.getGoodss().iterator();
        while (it.hasNext()) {
            Goods str = it.next();
            if (goods.getId().equals(str.getId())) {
                it.remove();
            }
        }
        this.managementManager.reduce(management);
        return bool;
    }
    @Override
    public Goods addGoods( Goods goods){
        Management management=this.managementManager.findbyManagementName(goods.getManagement().getName());
        goods.setManagement(management);
        this.save(goods);
        management.getGoodss().add(goods);
        this.managementManager.reduce(management);
        return goods;
    }
    @Override
    public Goods updateGoods( Goods goods){
        Management management=this.managementManager.findbyManagementName(goods.getManagement().getName());
        Goods de=this.findbyGoodsId(goods.getId());
        de.setName(goods.getName());
        de.setNum(goods.getNum());
        de.setNumber(goods.getNumber());
        de.setManagement(management);
        de.setDateModified(new Date());
        this.save(de);
        management.getGoodss().add(de);
        return goods;
    }
}
