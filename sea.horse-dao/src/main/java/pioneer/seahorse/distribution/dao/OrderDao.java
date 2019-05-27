package pioneer.seahorse.distribution.dao;


import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.distribution.domain.Order;

@Repository("orderDao")
public interface OrderDao extends GenericDao<Order,Long>{





}
