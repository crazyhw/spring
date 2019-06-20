package pioneer.seahorse.dealer.service;
import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.dealer.domain.Dealer;

import java.util.List;
/**
 *
 * @author 白疆银
 * @Date  2019/4/28 14:34
 *
 */
public interface DealerManager extends GenericManager<Dealer, Long>{
    List<Dealer> getAll();
}
