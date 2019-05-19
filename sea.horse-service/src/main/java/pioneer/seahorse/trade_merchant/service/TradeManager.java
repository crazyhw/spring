package pioneer.seahorse.trade_merchant.service;

import pioneer.seahorse.trade_merchant.domain.Trade;
import pioneer.seahorse.base.service.GenericManager;

import java.util.List;

public interface TradeManager extends GenericManager<Trade, Long> {

    String sayHello(String name);

    List<Trade> getAll();

}