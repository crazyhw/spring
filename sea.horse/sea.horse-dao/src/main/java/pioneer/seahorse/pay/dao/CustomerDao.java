package pioneer.seahorse.pay.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.pay.domain.Customer;
/**
 * CustomerDao
 * @author 吕庆宇
 * @Date  2019/4/5 16:32
 */
@Repository("customerDao")
public interface CustomerDao extends GenericTreeDao<Customer, Long> {
}
