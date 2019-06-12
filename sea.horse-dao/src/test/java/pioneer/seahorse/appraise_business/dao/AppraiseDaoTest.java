package pioneer.seahorse.appraise_business.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.appraise_business.domain.Appraise;
import pioneer.seahorse.base.dao.GenericDaoTestCase;

import java.util.List;

/**
 * Appraise测试
 * @author 杨留阳
 * @Date  2019/4/10 18:10
 */
public class AppraiseDaoTest extends GenericDaoTestCase<Long, Appraise, AppraiseDao> {

    private static final Logger logger = LogManager.getLogger(AppraiseDaoTest.class.getName());
    @Autowired
    AppraiseDao appraisedao;

    @Test
    public void testFindAll() {

        List<Appraise> all = this.appraisedao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<appraise> all={}", all);
        }
    }
}

