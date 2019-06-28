package pioneer.seahorse.orders.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.order.damain.Orders;
import pioneer.seahorse.order.dao.OrdersDao;

import java.util.List;

/**
 * OrdersDaoTest 类
 *
 * @author 张国伟
 * @date 2019/6/27 16:01
 */
public class OrdersDaoTest extends GenericDaoTestCase<Long, Orders, OrdersDao> {
    private static final Logger logger = LogManager.getLogger(OrdersDaoTest.class.getName());
    @Autowired
    OrdersDao orderDao;

    @Test
    public void testFindAll() {

        List<Orders> all = this.orderDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Orders> all={}", all); //$NON-NLS-1$
        }
    }
}
