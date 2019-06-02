package pioneer.seahorse.distribution.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.distribution.domain.Order;
import java.util.List;

public class OrderManagerTest extends GenericManagerTestCase<Long, Order, OrderManager> {

    private static final Logger logger = LogManager.getLogger(OrderManagerTest.class.getName());

    OrderManager orderManager;

    public OrderManagerTest() {
        super(Order.class);
    }

    @Autowired
    public void setOrderManager(OrderManager orderManager) {
        this.orderManager =orderManager;
    }

    @Test
    public void testGetAll() {
        List<Order> all = this.orderManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Order> all={}", all); //$NON-NLS-1$
        }
    }
}
