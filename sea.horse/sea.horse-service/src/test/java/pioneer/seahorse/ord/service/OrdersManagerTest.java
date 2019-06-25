package pioneer.seahorse.ord.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.order.service.OrderManager;
import pioneer.seahorse.orders.dao.OrderDao;
import pioneer.seahorse.orders.domain.ordrs;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class OrdersManagerTest extends GenericManagerTestCase<Long, ordrs, OrderManager> {

    private static final Logger logger = LogManager.getLogger(OrdersManagerTest.class.getName());

    @Autowired
    OrderManager orderManager ;

    @Autowired
    private OrderDao orderDao;

    public OrdersManagerTest() {
        super(ordrs.class);
    }


   // @Test
    public void testGetAll() {
       // List<ordrs> all = this.orderManager.getAll();
        if (logger.isInfoEnabled()) {
          //  logger.info("testGetAll() - List<ordrs> all={}", all); //$NON-NLS-1$
        }
    }
}
