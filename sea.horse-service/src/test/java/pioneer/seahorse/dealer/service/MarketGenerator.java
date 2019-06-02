package pioneer.seahorse.dealer.service;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.cargo_shelves.domain.Cargo;
import pioneer.seahorse.cargo_shelves.domain.Shelves;
import pioneer.seahorse.cargo_shelves.service.CargoManager;
import pioneer.seahorse.cargo_shelves.service.ShelvesManager;
import pioneer.seahorse.dealer.domain.Dealer;
import pioneer.seahorse.dealer.domain.Market;

/**
 *
 * @author 白疆银
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

    @Test
    public void AddMarket() {
        for (int i = 0; i < 3; i++) {
            Market market = new Market();
            market.setName("market_" + i);
            this.marketManager.save(market);
            for (int j = 0; j < 3; j++) {
                Market submarket = new Market();
                submarket.setName("submarket_" + i + "_" + j);
                submarket.setParent(market);
                this.marketManager.save(submarket);
                this.AddDealer(market);
            }
        }
    }

    public void AddDealer(Market market) {
        for (int i = 0; i < 3; i++) {
            Dealer dealer = new Dealer();
            dealer.setName("dealer_" + i);
            dealer.setAddress("中原工学院");
            dealer.setContact(i+123456);
            dealer.setMarket(market);
            this.dealerManager.save(dealer);
        }
    }
}
