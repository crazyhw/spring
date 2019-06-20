package pioneer.seahorse.pay.service;

import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.pay.domain.Customer;

import java.util.List;
/**
 *
 * @author 吕庆宇
 * @Date  2019/5/8 17:32
 *
 */
public interface CustomerManager extends GenericTreeManager<Customer, Long> {
    List<Customer> getAll();
}
