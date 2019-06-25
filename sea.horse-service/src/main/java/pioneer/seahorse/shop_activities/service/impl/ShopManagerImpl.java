package pioneer.seahorse.shop_activities.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;
import pioneer.seahorse.shop_activities.dao.ShopDao;
import pioneer.seahorse.shop_activities.domain.Shop;
import pioneer.seahorse.shop_activities.service.ShopManager;

import java.util.List;
import java.util.Optional;

/**
 * @author lvqingyv
 * @date 2019/6/21 20:15
 */
 @Service("shopManager")

public class ShopManagerImpl extends GenericTreeManagerImpl<Shop, Long> implements ShopManager {
    ShopDao shopDao;

    @Autowired
    public void setShopDaoDao(ShopDao shopDao) {
        this.shopDao = shopDao;
        this.treeDao = this.shopDao;
        this.dao = this.treeDao;
    }


    @Override
    public List<Shop> getAll() {
        List<Shop> result = this.dao.findAll();
        return result;
    }

    @Override
    public Shop findbyShopId(Long id) {
        Shop shop = null;
        List<Shop> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                shop=all.get(i);
        }
        return shop;
    }

    @Override
    public Shop findbyShopName(String name) {
        Shop shop = null;
        List<Shop> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getName().equals(name))
                shop=all.get(i);
        }
        return shop;
    }

    @Override
    public Boolean deletebyShopId(Long id) {
        Optional<Shop> stuList=this.dao.findById(id);
        if(stuList.equals(null)) {
            return false;
        } else {
            this.dao.delete(stuList.get());
            return true;
        }
    }

}
