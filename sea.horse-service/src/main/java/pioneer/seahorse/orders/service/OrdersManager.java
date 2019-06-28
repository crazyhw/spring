package pioneer.seahorse.orders.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.order.damain.Orders;

import java.util.List;

public interface OrdersManager extends GenericManager<Orders, Long> {
    List<Orders> getAll();

    Orders findbyOrdersId(Long id);

    Orders findbyOrdersName(String name);

    Boolean AddOrders(Orders cargo);

    Orders UpdataOrders(Orders cargo);

    Boolean DeleteOrders(Long id);

}
