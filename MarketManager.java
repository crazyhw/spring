package pioneer.seahorse.dealer.service;
import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.dealer.domain.Market;

import java.util.List;

public interface MarketManager extends GenericTreeManager<Market, Long> {
    List<Market> getAll();
}
