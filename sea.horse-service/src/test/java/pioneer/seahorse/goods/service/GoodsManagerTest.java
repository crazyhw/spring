package pioneer.seahorse.goods.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.goods.domain.Goods;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GoodsManagerTest extends GenericManagerTestCase<Long, Goods, GoodsManager> {
    private static final Logger logger = LogManager.getLogger(GoodsManagerTest.class.getName());

    GoodsManager goodsManager;

    public GoodsManagerTest() {
        super(Goods.class);
    }

    @Autowired
    public void setGoodsManager(GoodsManager goodsManager) {
        this.goodsManager = goodsManager;
    }

    @Test
    public void testGetAll() {
        List<Goods> all = this.goodsManager.getAll();
        assertNotNull(all);
//		assertEquals(100, all.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Goods> all={}", all); //$NON-NLS-1$
        }
    }

    @Test
    public void testSayHello() {
        String expected = "Hello, world!";
        String result = this.goodsManager.sayHello("world");
        if (logger.isInfoEnabled()) {
            logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
        }

        assertEquals(expected, result);
    }
}
