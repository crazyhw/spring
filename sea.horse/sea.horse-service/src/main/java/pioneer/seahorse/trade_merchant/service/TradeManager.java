package pioneer.seahorse.trade_merchant.service;

import pioneer.seahorse.trade_merchant.domain.Trade;
import pioneer.seahorse.base.service.GenericManager;

import java.util.List;
/**
 *
 * @author 于靖鑫
 * @Date  2019/5/9 20:26
 *
 */
public interface TradeManager extends GenericManager<Trade, Long> {


    List<Trade> getAll();

}