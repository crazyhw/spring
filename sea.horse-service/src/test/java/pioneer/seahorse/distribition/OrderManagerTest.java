package pioneer.seahorse.distribition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.distribition.domain.Order;
import pioneer.seahorse.distribition.service.OrderManager;

import java.util.List;

/**
 * distribition 类
 *
 * @author 郭万江
 * @date 2019/6/27 15:13
 */
public class OrderManagerTest extends GenericManagerTestCase<Long, Order, OrderManager> {
    private static final Logger logger = LogManager.getLogger(OrderManagerTest.class.getName());

    OrderManager orderManager;

    public OrderManagerTest() {
        super(Order.class);
    }

    @Autowired
    public void setOrderManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @Test
    public void testGetAll() {
        List<Order> all = this.orderManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Order> all={}", all); //$NON-NLS-1$
        }
    }
}
