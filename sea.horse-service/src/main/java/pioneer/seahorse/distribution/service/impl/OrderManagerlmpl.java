package pioneer.seahorse.distribution.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.distribution.dao.OrderDao;
import pioneer.seahorse.distribution.domain.Order;
import pioneer.seahorse.distribution.service.OrderManager;

import java.util.List;

@Service("orderManager")
public class OrderManagerlmpl extends GenericManagerImpl<Order, Long> implements OrderManager{


    OrderDao orderDao;

    @Autowired
    public void setCargoDao(OrderDao orderDao) {
        this.orderDao = orderDao;
        this.dao = this.orderDao;
    }


    @Override
    public List<Order> getAll() {
        List<Order> all = this.orderDao.findAll();
        return all;
    }

}
