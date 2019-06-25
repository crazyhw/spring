package pioneer.seahorse.orders.dao;
import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.orders.domain.ordrs;

@Repository("orderdao")
public interface OrderDao extends GenericDao<ordrs, Long> {
}
