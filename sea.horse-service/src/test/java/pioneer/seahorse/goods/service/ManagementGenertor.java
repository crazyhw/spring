package pioneer.seahorse.goods.service;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.goods.domain.Goods;
import pioneer.seahorse.goods.domain.Management;

/**
 *
 * @author lpl
 * @Date  2019/5/14 14:25
 *
 */
public class ManagementGenertor  extends GenericGenerator {
    GoodsManager goodsManager;
    ManagementManager marketManager;

    @Autowired
    public void setManagementManager(ManagementManager marketManager) {
        this.marketManager = marketManager;
    }

    @Autowired
    public void setGoodsManager(GoodsManager goodsManager) {
        this.goodsManager = goodsManager;
    }

    @Test
    public void AddManagement() {
        for (int i = 0; i < 3; i++) {
            Management market = new Management();
            market.setName("market_" + i);
            this.marketManager.save(market);
            for (int j = 0; j < 3; j++) {
                Management submarket = new Management();
                submarket.setName("submarket_" + i + "_" + j);
                submarket.setParent(market);
                this.marketManager.save(submarket);
                this.AddGoods(market);
            }
        }
    }

    public void AddGoods(Management market) {
        for (int i = 0; i < 3; i++) {
            Goods goods = new Goods();
            goods.setName("goods_" + i);
            goods.setNumber(i+"1");
            goods.setManagement(market);
            this.goodsManager.save(goods);
        }
    }
}
