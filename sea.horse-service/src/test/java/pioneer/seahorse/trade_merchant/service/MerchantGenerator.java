package pioneer.seahorse.trade_merchant.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.trade_merchant.domain.Merchant;
import pioneer.seahorse.base.service.GenericGenerator;

public class MerchantGenerator extends GenericGenerator {

    MerchantManager merchantManager;

    @Autowired
    public void setMerchantManager(MerchantManager merchantManager) {
        this.merchantManager = merchantManager;
    }

    @Test
    public void testAddMerchant() {
        for (int i = 0; i < 10; i++) {
            Merchant merchant = new Merchant();
            merchant.setName("merchant_" + i);
            merchant = this.merchantManager.save(merchant);
            for (int j = 0; j < 10; j++) {
                Merchant submerchant = new Merchant();
                submerchant.setName("submerchant_" + i + "_" + j);
                submerchant.setParent(merchant);
                this.merchantManager.save(submerchant);
            }

        }

    }

}
