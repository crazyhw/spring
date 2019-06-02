package pioneer.seahorse.dealer.service;
import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.dealer.domain.Dealer;

import java.util.List;

public interface DealerManager extends GenericManager<Dealer, Long>{
    List<Dealer> getAll();
}
