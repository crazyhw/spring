package pioneer.seahorse.appraise_business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.appraise_business.dao.BusinessDao;
import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.appraise_business.service.BusinessManager;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;

import java.util.List;

@Service(value = "businessManager")
public class BusinessManagerImpl extends GenericTreeManagerImpl<Business, Long> implements BusinessManager {

    BusinessDao businessDao;

    @Autowired
    public void setGropuDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
        this.treeDao = this.businessDao;
        this.dao = this.treeDao;
    }
    @Override
    public List<Business> getAll() {
        List<Business> all = this.businessDao.findAll();
        return all;
    }

}

