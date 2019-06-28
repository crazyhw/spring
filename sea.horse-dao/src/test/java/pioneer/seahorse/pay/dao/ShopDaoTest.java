package pioneer.seahorse.pay.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import pioneer.seahorse.pay.domain.Shop;

import java.util.List;

/**
 * ShopDao 类
 *
 * @author 吕庆宇
 * @date 2019/6/23 23:40
 */
public class ShopDaoTest extends GenericTreeDaoTestCase<Long, Shop, ShopDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(ShopDaoTest.class.getName());

    ShopDao shopDao;

    @Autowired
    public void setShopDao(ShopDao shopDao) {
        this.shopDao = shopDao;
        this.dao = this.shopDao;
    }

    @Test
    public void testGetRoot() {
        List<Shop> roots = this.shopDao.getRoot();
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Shop> roots={}", roots); //$NON-NLS-1$
        }


    }

}