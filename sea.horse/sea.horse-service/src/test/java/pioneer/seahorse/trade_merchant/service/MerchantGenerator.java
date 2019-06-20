package pioneer.seahorse.trade_merchant.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.trade_merchant.domain.Trade;
import pioneer.seahorse.trade_merchant.domain.Merchant;
/**
 *
 * @author 于靖鑫
 * @Date  2019/5/26 13:15
 *
 */
public class MerchantGenerator extends GenericGenerator {

    TradeManager tradeManager;
    MerchantManager merchantManager;

    @Autowired
    public void setMerchantManager(MerchantManager merchantManager) {
        this.merchantManager = merchantManager;
    }

    @Autowired
    public void setTradeManager(TradeManager tradeManager) {
        this.tradeManager = tradeManager;
    }

    @Test
    public void AddMerchant() {
        for (int i = 0; i < 10; i++) {
            Merchant merchant = new Merchant();
            merchant.setName("merchant_" + i);
            this.merchantManager.save(merchant);
            for (int j = 0; j < 10; j++) {
                Merchant submerchant = new Merchant();
                submerchant.setName("submerchant_" + i + "_" + j);
                submerchant.setParent(merchant);
                this.merchantManager.save(submerchant);
                this.AddTrade(merchant);
            }

        }

    }
    public void AddTrade(Merchant merchant) {
        for (int i = 0; i < 10; i++) {
            Trade trade = new Trade();
            trade.setName("trade_" + i);
            trade.setNumber(i+10);
            trade.setPrice(100);
            trade.setMerchant(merchant);
            this.tradeManager.save(trade);
        }
    }
}
