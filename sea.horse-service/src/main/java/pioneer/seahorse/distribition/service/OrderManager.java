package pioneer.seahorse.distribition.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.distribition.domain.Order;

import java.util.List;

public interface OrderManager extends GenericManager<Order, Long> {
    List<Order> getAll();

    Order findbyOrderId(Long id);

    Order findbyOrderName(String name);

    Boolean AddOrder(Order cargo);

    Order UpdataOrder(Order cargo);

    Boolean DeleteOrder(Long id);

}
