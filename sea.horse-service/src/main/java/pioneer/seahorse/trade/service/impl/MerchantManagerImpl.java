package pioneer.seahorse.trade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.trade.dao.MerchantDao;
import pioneer.seahorse.trade.domain.Merchant;
import pioneer.seahorse.trade.service.MerchantManager;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service("merchantManager")
public class MerchantManagerImpl extends GenericManagerImpl<Merchant, Long> implements MerchantManager {

    MerchantDao merchantDao;


    @Autowired
    public void setMerchantDao(MerchantDao merchantDao) {
        this.merchantDao = merchantDao;
        this.dao = this.merchantDao;
    }


    @Override
    public List<Merchant> getAll() {
        List<Merchant> result = this.dao.findAll();
        return result;
    }

    @Override
    public Merchant findbyMerchantName(String name) {
        Merchant merchant = null;
        List<Merchant> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
            if (all.get(i).getName().equals(name))
                merchant=all.get(i);
        return merchant;
    }

    @Override
    public Merchant findbyMerchantId(Long id) {
        Merchant merchant = null;
        List<Merchant> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                merchant=all.get(i);
        }
        return merchant;
    }

    @Override
    public Boolean deletebyMerchantId(Long id) {
        Optional<Merchant> merList=this.dao.findById(id);
        if(merList.equals(null)) {
            return false;
        } else {
            this.dao.delete(merList.get());
            return true;
        }
    }

    @Override
    public Boolean updateMerchant( Merchant merchant){
        Merchant mer=this.findbyMerchantId(merchant.getId());
        mer.setNum(merchant.getNum());
        mer.setName(merchant.getName());
        mer.setMarks(merchant.getMarks());
        mer.setDateModified(new Date());
        this.save(mer);
        return true;
    }

}
