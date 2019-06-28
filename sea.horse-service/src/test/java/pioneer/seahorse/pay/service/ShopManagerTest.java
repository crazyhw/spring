package pioneer.seahorse.pay.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;
import pioneer.seahorse.pay.domain.Shop;

import java.util.List;

/**
 * ShopManagerTest 类
 *
 * @author 吕庆宇
 * @date 2019/6/27 16:20
 */
public class ShopManagerTest extends GenericTreeManagerTestCase<Long, Shop, ShopManager> {
    ShopManager shopManager;

    public ShopManagerTest() {
        super(Shop.class);
    }

    @Autowired
    public void setShopManager(ShopManager shopManager) {
        this.shopManager = shopManager;
        this.manager = this.shopManager;
    }

    @Test
    public void testGetAll() {
        List<Shop> all = this.shopManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Shop> all={}", all); //$NON-NLS-1$
        }
    }
}
