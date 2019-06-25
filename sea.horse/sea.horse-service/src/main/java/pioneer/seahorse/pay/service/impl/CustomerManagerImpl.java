package pioneer.seahorse.pay.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;
import pioneer.seahorse.pay.dao.CustomerDao;
import pioneer.seahorse.pay.domain.Customer;
import pioneer.seahorse.pay.service.CustomerManager;

import java.util.List;
/**
 *
 * @author 吕庆宇
 * @Date  2019/5/8 17:32
 *
 */
@Service(value = "customerManager")
public class CustomerManagerImpl extends GenericTreeManagerImpl<Customer, Long> implements CustomerManager {

    CustomerDao customerDao;

    @Autowired
    public void setCustomerDaoDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
        this.treeDao = this.customerDao;
        this.dao = this.treeDao;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> all = this.customerDao.findAll();
        return all;
    }
}