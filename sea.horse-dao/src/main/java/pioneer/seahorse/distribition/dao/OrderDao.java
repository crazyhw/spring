package pioneer.seahorse.distribition.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.distribition.domain.Order;

@Repository("orderDao")
public interface OrderDao extends GenericDao<Order, Long> {
}
