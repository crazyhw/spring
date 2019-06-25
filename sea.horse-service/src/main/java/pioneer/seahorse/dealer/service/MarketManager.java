package pioneer.seahorse.dealer.service;
import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.dealer.domain.Dealer;
import pioneer.seahorse.dealer.domain.Market;

import java.util.List;
/**
 *
 * @author 白疆银
 * @Date  2019/4/28 14:34
 *
 */
public interface MarketManager extends GenericTreeManager<Market, Long> {
    List<Market> getAll();
    Market findbyMarketId(Long Id);
    Boolean deletebyMarketId(Long Id);
    Market findbyMarketName(String name);
    void reduce(Market market);
    void updata();
    Boolean addMarket( Market market);
    Boolean updateMarket( Market market);
}
