
package pioneer.seahorse.pay.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;
import pioneer.seahorse.pay.domain.Customer;
import java.util.List;
/**
 *
 * @author 吕庆宇
 * @Date  2019/5/23 17:14
 *
 */
public class CustomerManagerTest extends GenericTreeManagerTestCase<Long, Customer, CustomerManager> {

    CustomerManager customerManager;

    public CustomerManagerTest() {
        super(Customer.class);
    }

    @Autowired
    public void setCustomerManager(CustomerManager customerManager) {
        this.customerManager = customerManager;
        this.manager = this.customerManager;
    }

    @Test
    public void testGetAll() {
        List<Customer> all = this.customerManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Customer> all={}", all); //$NON-NLS-1$
        }
    }

}
