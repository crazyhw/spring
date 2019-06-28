package pioneer.seahorse.appraise_business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pioneer.seahorse.appraise_business.dao.BusinessDao;
import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.appraise_business.service.BusinessManager;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;

import java.util.Date;
import java.util.List;

/**
 *
 * @author 杨留阳
 * @Date  2019/4/25 15:33
 *
 */
@Service(value = "businessManager")
public class BusinessManagerImpl extends GenericTreeManagerImpl<Business, Long> implements BusinessManager {

    BusinessDao businessDao;

    @Autowired
    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
        this.dao = this.businessDao;
    }


    @Override
    public List<Business> getAll() {
        List<Business> result = this.dao.findAll();
        return result;
    }

    @Override
    public Business findbyBusinessId(Long id) {
        Business business = null;
        List<Business> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
            if (all.get(i).getId().equals(id))
                business=all.get(i);
        return business;
    }

    @Override
    public Business findbyBusinessName(String name) {
        System.out.println(name);
        Business business = null;
        List<Business> all = this.dao.findAll();
        for (int i = 0; i < all.size(); i++)
            if (all.get(i).getName().equals(name))
                business = all.get(i);
        return business;
    }

    @Override
    public Boolean deletebyBusinessId(Long id) {
        this.dao.deleteById(id);
        return true;
    }

    @Override
    public Business updateBusiness(Business business){
        Business de=this.findbyBusinessId(business.getId());
        System.out.println(business);
        System.out.println(de);
        de.setNum(business.getNum());
        de.setName(business.getName());
        de.setMarket(business.getMarket());
        de.setDateModified(new Date());
        this.save(de);
        return business;
    }

}

