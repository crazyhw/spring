package pioneer.seahorse.distribition.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.distribition.domain.Order;

import java.util.List;

/**
 * OrderDaoTest 类
 *
 * @author 郭万江
 * @date 2019/6/27 14:52
 */
public class OrderDaoTest extends GenericDaoTestCase<Long, Order, OrderDao> {
    private static final Logger logger = LogManager.getLogger(OrderDaoTest.class.getName());
    @Autowired
    OrderDao orderDao;

    @Test
    public void testFindAll() {

        List<Order> all = this.orderDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Order> all={}", all); //$NON-NLS-1$
        }
    }
}