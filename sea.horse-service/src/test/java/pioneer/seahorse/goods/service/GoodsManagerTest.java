package pioneer.seahorse.goods.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.goods.domain.Goods;

import java.util.List;
/**
 *
 * @author lpl
 * @Date  2019/5/14 14:25
 *
 */
public class GoodsManagerTest extends GenericManagerTestCase<Long, Goods, GoodsManager>  {
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
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Goods> all={}", all); //$NON-NLS-1$
        }
    }
}

