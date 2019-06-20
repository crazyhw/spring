package pioneer.seahorse.appraise_business.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;

import java.util.List;
/**
 *
 * @author 杨留阳
 * @Date  2019/5/10 20:25
 *
 */
public class BusinessManagerTest extends GenericTreeManagerTestCase<Long, Business, BusinessManager> {

    BusinessManager businessManager;

    public BusinessManagerTest() { super(Business.class); }

    @Autowired
    public void setBusinessManager(BusinessManager businessManager) {
        this.businessManager = businessManager;
        this.manager = this.businessManager;
    }

    @Test
    public void testAddBusiness() {
        List<Business> all = this.businessManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Shelves> all={}", all); //$NON-NLS-1$
        }

    }

}