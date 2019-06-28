package pioneer.seahorse.orders.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.order.damain.Orders;
import pioneer.seahorse.order.damain.User;
import pioneer.seahorse.order.dao.OrdersDao;
import pioneer.seahorse.orders.service.OrdersManager;
import pioneer.seahorse.orders.service.UserManager;

import java.util.Date;
import java.util.List;

/**
 * OrderssManagerImpl 类
 *
 * @author 张国伟
 * @date 2019/6/27 16:05
 */
@Service("ordersManager")

public class OrdersManagerImpl extends GenericManagerImpl<Orders, Long> implements OrdersManager {

    OrdersDao ordersDao;
    UserManager userManager;

    @Autowired
    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
        this.dao = this.ordersDao;
    }
    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager=userManager;
    }


    @Override
    public List<Orders> getAll() {
        return this.dao.findAll();
    }

    @Override
    public Orders findbyOrdersId(Long id) {
        Orders orders = null;
        List<Orders> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                orders=all.get(i);
        }
        return orders;
    }

    @Override
    public Orders findbyOrdersName(String name) {
        Orders orders = null;
        List<Orders> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getName().equals(name))
                orders=all.get(i);
        }
        return orders;
    }


    @Override
    public Boolean AddOrders(Orders orders){
        String name=orders.getUser().getName();
        User user=this.userManager.findbyUserName(name);
        orders.setUser(user);
        this.save(orders);
        user.getOrders().add(orders);
        return true;
    }

    @Override
    public Orders UpdataOrders(Orders orders){
        User user=this.userManager.findbyUserName(orders.getUser().getName());
        Orders cg=this.findbyOrdersId(orders.getId());
        cg.setName(orders.getName());
        cg.setNum(orders.getNum());
        cg.setSale(orders.getSale());
        cg.setUser(user);
        cg.setDateModified(new Date());
        this.save(cg);
        user.getOrders().add(cg);
        return cg;
    }

    @Override
    public Boolean DeleteOrders(Long id){
        this.dao.deleteById(id);
        return true;
    }
}
