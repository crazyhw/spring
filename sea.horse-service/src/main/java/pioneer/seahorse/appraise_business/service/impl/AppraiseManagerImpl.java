package pioneer.seahorse.appraise_business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.appraise_business.service.BusinessManager;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;

import pioneer.seahorse.appraise_business.dao.AppraiseDao;
import pioneer.seahorse.appraise_business.domain.Appraise;
import pioneer.seahorse.appraise_business.service.AppraiseManager;

import java.util.Date;
import java.util.List;


/**
 *
 * @author 杨留阳
 * @Date  2019/4/25 15:33
 *
 */
@Service("appraiseManager")
public class AppraiseManagerImpl extends GenericManagerImpl<Appraise, Long> implements AppraiseManager {

    AppraiseDao appraiseDao;
    BusinessManager businessManager;
    @Autowired
    public void setAppraiseDao(AppraiseDao appraiseDao) {
        this.appraiseDao = appraiseDao;
        this.dao = this.appraiseDao;
    }

    @Autowired
    public void setBusinessManager(BusinessManager businessManager){
        this.businessManager = businessManager;
    }

    @Override
    public List<Appraise> getAll() {
        List<Appraise> result = this.dao.findAll();
        return result;
    }

    @Override
    public Appraise findbyAppraiseId(Long id) {
        Appraise appraise = null;
        List<Appraise> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                appraise=all.get(i);
        }
        return appraise;
    }

    @Override
    public Appraise findbyAppraiseName(String name) {
        Appraise appraise = null;
        List<Appraise> all = this.dao.findAll();
        for (int i = 0; i < all.size(); i++)
            if (all.get(i).getName().equals(name))
                appraise = all.get(i);
        return appraise;
    }


    @Override
    public Boolean deletebyAppraiseId(Long id) {
        this.dao.deleteById(id);
        return true;
    }

    @Override
    public Appraise addAppraise(Appraise appraise){
        Business business=this.businessManager.findbyBusinessName(appraise.getBusiness().getName());
        appraise.setBusiness(business);
        this.save(appraise);
        business.getAppraise().add(appraise);
        return appraise;
    }

    @Override
    public Appraise updateAppraise(Appraise appraise){
        Business business=this.businessManager.findbyBusinessName(appraise.getBusiness().getName());
        Appraise de=this.findbyAppraiseId(appraise.getId());
        de.setName(appraise.getName());
        de.setNumber(appraise.getNumber());
        de.setEvaluate(appraise.getEvaluate());
        de.setBusiness(business);
        de.setDateModified(new Date());
        this.save(de);
        business.getAppraise().add(de);
        return appraise;
    }
}