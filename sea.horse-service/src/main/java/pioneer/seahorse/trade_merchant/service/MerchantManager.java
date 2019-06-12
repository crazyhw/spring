package pioneer.seahorse.trade_merchant.service;

import pioneer.seahorse.trade_merchant.domain.Merchant;
import pioneer.seahorse.base.service.GenericTreeManager;
import java.util.List;
/**
 *
 * @author 于靖鑫
 * @Date  2019/5/9 20:26
 *
 */
public interface MerchantManager extends GenericTreeManager<Merchant, Long> {
    List<Merchant> getAll();
}