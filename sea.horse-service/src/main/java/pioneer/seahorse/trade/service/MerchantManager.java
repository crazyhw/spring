package pioneer.seahorse.trade.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.trade.domain.Merchant;

import java.util.List;

public interface MerchantManager extends GenericManager<Merchant, Long> {

    List<Merchant> getAll();

    Merchant findbyMerchantName(String name);

    Boolean deletebyMerchantId(Long id);

    Boolean updateMerchant( Merchant merchant);

    Merchant findbyMerchantId(Long id);
}
