package pioneer.seahorse.distribition.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.distribition.dao.OrderDao;
import pioneer.seahorse.distribition.domain.Deliveryclerk;
import pioneer.seahorse.distribition.domain.Order;
import pioneer.seahorse.distribition.service.DeliveryclerkManager;
import pioneer.seahorse.distribition.service.OrderManager;

import java.util.Date;
import java.util.List;

/**
 * OrderManagerImpl 类
 *
 * @author 郭万江
 * @date 2019/6/27 14:57
 */
@Service("orderManager")

public class OrderManagerImpl extends GenericManagerImpl<Order, Long> implements OrderManager {

    OrderDao orderDao;
    DeliveryclerkManager deliveryclerkManager;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
        this.dao = this.orderDao;
    }
    @Autowired
    public void setDeliveryclerkManager(DeliveryclerkManager deliveryclerkManager) {
        this.deliveryclerkManager=deliveryclerkManager;
    }


    @Override
    public List<Order> getAll() {
        return this.dao.findAll();
    }

    @Override
    public Order findbyOrderId(Long id) {
        Order order = null;
        List<Order> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                order=all.get(i);
        }
        return order;
    }

    @Override
    public Order findbyOrderName(String name) {
        Order order = null;
        List<Order> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getName().equals(name))
                order=all.get(i);
        }
        return order;
    }


    @Override
    public Boolean AddOrder(Order order){
        String name=order.getDeliveryclerk().getName();
        Deliveryclerk deliveryclerk=this.deliveryclerkManager.findbyDeliveryclerkName(name);
        order.setDeliveryclerk(deliveryclerk);
        this.save(order);
        deliveryclerk.getOrders().add(order);
        return true;
    }

    @Override
    public Order UpdataOrder(Order order){
        Deliveryclerk deliveryclerk=this.deliveryclerkManager.findbyDeliveryclerkName(order.getDeliveryclerk().getName());
        Order cg=this.findbyOrderId(order.getId());
        cg.setName(order.getName());
        cg.setNum(order.getNum());
        cg.setDeliveryclerk(deliveryclerk);
        cg.setDateModified(new Date());
        this.save(cg);
        deliveryclerk.getOrders().add(cg);
        return cg;
    }

    @Override
    public Boolean DeleteOrder(Long id){
        this.dao.deleteById(id);
        return true;
    }
}