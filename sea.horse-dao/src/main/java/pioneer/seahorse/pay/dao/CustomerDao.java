package pioneer.seahorse.pay.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.pay.domain.Customer;

@Repository("customerDao")
public interface CustomerDao extends GenericTreeDao<Customer, Long> {
}
