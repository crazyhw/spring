
package pioneer.seahorse.pay.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.pay.domain.Customer;

/**
 *
 * @author 吕庆宇
 *
 */
public class CustomerGenerator extends GenericGenerator {

    CustomerManager customerManager;

    @Autowired
    public void setCustomerManager(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }
    @Test
    public void testAddCustomer() {
        for (int i = 0; i < 3; i++) {
            Customer customer = new Customer();
            customer.setName("customer_" + i);
            customer = this.customerManager.save(customer);
            for (int j = 0; j < 3; j++) {
                Customer subcustomer = new Customer();
                subcustomer.setName("subcustomer_" + i + "_" + j);
                subcustomer.setParent(customer);
                this.customerManager.save(subcustomer);
            }

        }

    }
}
