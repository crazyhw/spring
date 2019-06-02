package pioneer.seahorse.trade_merchant.service;

import pioneer.seahorse.trade_merchant.domain.Merchant;
import pioneer.seahorse.base.service.GenericTreeManager;
import java.util.List;

public interface MerchantManager extends GenericTreeManager<Merchant, Long> {
    List<Merchant> getAll();
}