package pioneer.seahorse.appraise_business.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import java.util.List;
import static org.junit.Assert.assertEquals;
/**
 * Business测试
 * @author 杨留阳
 * @Date  2019/4/10 18:10
 */
public class BusinessDaoTest extends GenericTreeDaoTestCase<Long, Business, BusinessDao> {

    private static final Logger logger = LogManager.getLogger(BusinessDaoTest.class.getName());

    BusinessDao businessDao;

    @Autowired
    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
        this.dao = this.businessDao;
    }

    @Test
    public void testGetRoot() {
        int root_size = 3;
        for(int i = 0; i < root_size; i++) {
            Business business = new Business();
            business.setName("business_" + i);
            for(int j = 0; j < 3; j++) {
                Business s = new Business();
                s.setName("business_" + i + "_" + j);
                s.setParent(business);
            }
            this.businessDao.save(business);
        }

        List<Business> roots = this.businessDao.getRoot();
        assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Business> roots={}", roots); //$NON-NLS-1$
        }


    }

}