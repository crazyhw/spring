package pioneer.seahorse.distribition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;
import pioneer.seahorse.distribition.dao.DeliveryclerkDao;
import pioneer.seahorse.distribition.domain.Deliveryclerk;
import pioneer.seahorse.distribition.service.DeliveryclerkManager;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * DeliveryclerkManagerImpl 类
 *
 * @author 郭万江
 * @date 2019/6/27 14:57
 */
@Service(value = "deliveryclerkManager")
public class DeliveryclerkManagerImpl extends GenericTreeManagerImpl<Deliveryclerk, Long> implements DeliveryclerkManager {
    DeliveryclerkDao deliveryclerkDao;

    @Autowired
    public void setDeliveryclerkDaoDao(DeliveryclerkDao deliveryclerkDao) {
        this.deliveryclerkDao = deliveryclerkDao;
        this.treeDao = this.deliveryclerkDao;
        this.dao = this.treeDao;
    }

    @Override
    public List<Deliveryclerk> getAll() {
        List<Deliveryclerk> all = this.deliveryclerkDao.findAll();
        return all;
    }

    @Override
    public Deliveryclerk addDeliveryclerk( Deliveryclerk deliveryclerk){
        this.save(deliveryclerk);
        return deliveryclerk;
    }

    @Override
    public Deliveryclerk findbyDeliveryclerkId(Long id) {
        Deliveryclerk deliveryclerk = null;
        List<Deliveryclerk> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                deliveryclerk=all.get(i);
        }
        return deliveryclerk;
    }

    @Override
    public Deliveryclerk findbyDeliveryclerkName(String name) {
        Deliveryclerk deliveryclerk = new Deliveryclerk();
        List<Deliveryclerk> all = this.dao.findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getName().equals(name))
                deliveryclerk = all.get(i);
        }
        return deliveryclerk;
    }

    @Override
    public Boolean deletebyDeliveryclerkId(Long id) {
        Optional<Deliveryclerk> stuList=this.dao.findById(id);
        if(stuList.equals(null)) {
            return false;
        } else {
            this.dao.delete(stuList.get());
            return true;
        }
    }

    @Override
    public Deliveryclerk UpdataDeliveryclerk(Deliveryclerk deliveryclerk){
        Deliveryclerk del=this.findbyDeliveryclerkId(deliveryclerk.getId());
        del.setNum(deliveryclerk.getNum());
        del.setName(deliveryclerk.getName());
        del.setContact(deliveryclerk.getContact());
        del.setOrders(deliveryclerk.getOrders());
        del.setDateModified(new Date());
        this.save(del);
        return deliveryclerk;
    }

}
