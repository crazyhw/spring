package pioneer.seahorse.goods.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;

import pioneer.seahorse.goods.domain.Goods;

import java.util.List;

/**
 * Goods测试
 * @author lpl
 * @Date  2019/4/13 09:32
 */
public class GoodsDaoTest extends GenericDaoTestCase<Long, Goods, GoodsDao> {
    private static final Logger logger = LogManager.getLogger(GoodsDaoTest.class.getName());
    @Autowired
    GoodsDao goodsDao;

    @Test
    public void testFindAll() {

        List<Goods> all = this.goodsDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Goods> all={}", all); //$NON-NLS-1$
        }
    }
}

