package pioneer.seahorse.goods.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.goods.domain.Goods;

import java.util.List;

/**
 *
 * @author 李培磊
 *
 */
public class GoodsDaoTest extends GenericDaoTestCase<Long, Goods, GoodsDao> {

    private static final Logger logger = LogManager.getLogger(GoodsDaoTest.class.getName());
    @Autowired
    GoodsDao GoodsDao;

    @Test
    public void testFindAll() {

        List<Goods> all = this.GoodsDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Goods> all={}", all); //$NON-NLS-1$
        }
    }
}
