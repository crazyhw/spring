
package pioneer.seahorse.pay.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import pioneer.seahorse.pay.domain.Customer;

import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 *
 * @author 吕庆宇
 *
 */
public class CustomerDaoTest extends GenericTreeDaoTestCase<Long, Customer, CustomerDao> {

    private static final Logger logger = LogManager.getLogger(CustomerDaoTest.class.getName());
    CustomerDao customerDao;
    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
        this.dao = this.customerDao;
    }
    @Test
    public void testGetRoot() {
        int root_size = 3;
        for(int i = 0; i < root_size; i++) {
            Customer customer = new Customer();
            customer.setName("customer" + i);
            for(int j = 0; j < 3; j++) {
                Customer s = new Customer();
                s.setName("customer" + i + "_" + j);
                s.setParent(customer);
            }
            this.customerDao.save(customer);
        }

        List<Customer> roots = this.customerDao.getRoot();
       assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Customer> roots={}", roots); //$NON-NLS-1$
        }


    }


}
