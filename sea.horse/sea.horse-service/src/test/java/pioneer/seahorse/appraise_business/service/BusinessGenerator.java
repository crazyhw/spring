package pioneer.seahorse.appraise_business.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.appraise_business.domain.Appraise;
import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.base.service.GenericGenerator;
/**
 * Add测试
 * @author 杨留阳
 * @Date  2019/5/10 20:25
 *
 */
public class BusinessGenerator extends GenericGenerator {

    AppraiseManager appraiseManager;
    BusinessManager businessManager;
    @Autowired
    public void setAppraiseManager(AppraiseManager appraiseManager) {
        this.appraiseManager = appraiseManager;
    }

    @Autowired
    public void setBusinessManager(BusinessManager businessManager) {
        this.businessManager = businessManager;
    }

    @Test
    public void AddBusiness() {
        for (int i = 0; i < 3; i++) {
            Business business = new Business();
            business.setName("business_" + i);
            this.businessManager.save(business);
            for (int j = 0; j < 3; j++) {
                Business subbusiness = new Business();
                subbusiness.setName("subbusiness_" + i + "_" + j);
                subbusiness.setParent(subbusiness);
                this.businessManager.save(subbusiness);
            }
        }
    }
    public void AddAppraise(Business business) {
        for (int i = 0; i < 3; i++) {
            Appraise appraise = new Appraise();
            appraise.setName("appraise_" + i);
            appraise.setCount(i+10);
            appraise.setPrice(100);
            appraise.setBusiness(business);
            this.appraiseManager.save(appraise);
        }
    }
}

