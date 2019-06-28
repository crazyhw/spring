package pioneer.seahorse.dealer.service;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;


/**
 *
 * @author 白疆银
 * @Date  2019/5/14 14:25
 *
 */
public class MarketGenerator extends GenericGenerator {
    DealerManager dealerManager;
    MarketManager marketManager;

    @Autowired
    public void setMarketManager(MarketManager marketManager) {
        this.marketManager = marketManager;
    }

    @Autowired
    public void setDealerManager(DealerManager dealerManager) {
        this.dealerManager = dealerManager;
    }

    /*@Test
    public void AddMarket() {
        Market market = new Market();
        market.setName("第一货架");
        this.marketManager.save(market);
        this.AddDealer(market);
    }

    public void AddDealer(Market market) {
        Dealer cargo = new Dealer();
        cargo.setName("货物");
        cargo.setNum("1");
        cargo.setPrice(123);
        cargo.setNumber(100);
        cargo.setMarket(market);
        this.cargoManager.save(cargo);
    }*/
}
