package pioneer.seahorse.distribution.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.distribution.domain.Order;

import java.util.List;

public interface OrderManager  extends GenericManager<Order, Long> {

    List<Order> getAll();
}
