package pioneer.seahorse.order.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.order.damain.Orders;

@Repository("ordersDao")
public interface OrdersDao extends GenericDao<Orders, Long> {
}
