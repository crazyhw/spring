package pioneer.seahorse.appraise_business.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.appraise_business.dao.BusinessDao;
import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;

import java.util.List;

/**
 * BusinessDaoTest 类
 *
 * @author 杨留阳
 * @date 2019/6/24 0:31
 */
public class BusinessDaoTest extends GenericTreeDaoTestCase<Long, Business, BusinessDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(BusinessDaoTest.class.getName());

    BusinessDao businessDao;

    @Autowired
    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
        this.dao = this.businessDao;
    }

    @Test
    public void testGetRoot() {
        List<Business> roots = this.businessDao.getRoot();
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Business> roots={}", roots); //$NON-NLS-1$
        }


    }

}
