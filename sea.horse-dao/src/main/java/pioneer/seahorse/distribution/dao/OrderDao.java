package pioneer.seahorse.distribution.dao;


import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.distribution.domain.Order;
/**
 * OrderDao
 * @author 郭万江
 * @Date  2019/4/1 14:12
 */
@Repository("orderDao")
public interface OrderDao extends GenericDao<Order,Long>{



}
