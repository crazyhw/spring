package pioneer.seahorse.trade_merchant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.trade_merchant.dao.MerchantDao;
import pioneer.seahorse.trade_merchant.domain.Merchant;
import pioneer.seahorse.trade_merchant.service.MerchantManager;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;

import java.util.List;

@Service(value = "merchantManager")
public class MerchantManagerImpl extends GenericTreeManagerImpl<Merchant, Long> implements MerchantManager {

    MerchantDao merchantDao;

    @Autowired
    public void setMerchantDao(MerchantDao merchantDao) {
        this.merchantDao = merchantDao;
        this.treeDao = this.merchantDao;
        this.dao = this.treeDao;
    }

    @Override
    public List<Merchant> getAll() {
        List<Merchant> all = this.merchantDao.findAll();
        return all;
    }
}
