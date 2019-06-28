package pioneer.seahorse.orders.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.order.damain.Orders;

import java.util.List;

/**
 * OrdersManagerTest 类
 *
 * @author 张国伟
 * @date 2019/6/27 16:15
 */
public class OrdersManagerTest extends GenericManagerTestCase<Long, Orders, OrdersManager> {
    private static final Logger logger = LogManager.getLogger(OrdersManagerTest.class.getName());

    OrdersManager ordersManager;

    public OrdersManagerTest() {
        super(Orders.class);
    }

    @Autowired
    public void setOrdersManager(OrdersManager ordersManager) {
        this.ordersManager = ordersManager;
    }

    @Test
    public void testGetAll() {
        List<Orders> all = this.ordersManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Orders> all={}", all); //$NON-NLS-1$
        }
    }
}
