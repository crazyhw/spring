package pioneer.seahorse.appraise_business.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.appraise_business.dao.AppraiseDao;
import pioneer.seahorse.appraise_business.domain.Appraise;
import pioneer.seahorse.base.dao.GenericDaoTestCase;

import java.util.List;

/**
 * AppraiseDaoTest 类
 *
 * @author 杨留阳
 * @date 2019/6/24 0:30
 */
public class AppraiseDaoTest extends GenericDaoTestCase<Long, Appraise, AppraiseDao> {
    private static final Logger logger = LogManager.getLogger(AppraiseDaoTest.class.getName());
    @Autowired
    AppraiseDao appraiseDao;

    @Test
    public void testFindAll() {
        List<Appraise> all = this.appraiseDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Appraise> all={}", all); //$NON-NLS-1$
        }
    }
}
