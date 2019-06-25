package pioneer.seahorse.shop_activities.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.shop_activities.domain.Activities;

import java.util.List;

/**
 * ActivitiesDaoTest 类
 *
 * @author 吕庆宇
 * @date 2019/6/23 23:42
 */
public class ActivitiesDaoTest extends GenericDaoTestCase<Long, Activities, ActivitiesDao> {
    private static final Logger logger = LogManager.getLogger(ActivitiesDaoTest.class.getName());
    @Autowired
    ActivitiesDao activitiesDao;

    @Test
    public void testFindAll() {

        List<Activities> all = this.activitiesDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Activities> all={}", all); //$NON-NLS-1$
        }
    }
}
