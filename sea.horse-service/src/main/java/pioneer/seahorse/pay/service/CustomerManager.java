package pioneer.seahorse.pay.service;

import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.pay.domain.Customer;

import java.util.List;

public interface CustomerManager extends GenericTreeManager<Customer, Long> {
    List<Customer> getAll();
}
