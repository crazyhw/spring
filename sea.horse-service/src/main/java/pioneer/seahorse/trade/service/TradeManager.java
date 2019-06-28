package pioneer.seahorse.trade.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.trade.domain.Trade;

import java.util.List;

public interface TradeManager extends GenericManager<Trade, Long> {

    List<Trade> getAll();

    Trade findbyTradeName(String name);

    Boolean deletebyTradeId(Long id);

    Trade updateTrade(Trade trade);

    Trade findbyTradeId(Long id);
}
