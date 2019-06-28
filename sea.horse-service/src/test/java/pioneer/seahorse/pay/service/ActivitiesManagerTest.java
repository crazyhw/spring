package pioneer.seahorse.pay.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.pay.domain.Activities;

import java.util.List;

/**
 * ActivitiesManagerTest 类
 *
 * @author 吕庆宇
 * @date 2019/6/27 16:20
 */
public class ActivitiesManagerTest extends GenericManagerTestCase<Long, Activities, ActivitiesManager> {
    private static final Logger logger = LogManager.getLogger(ActivitiesManagerTest.class.getName());

    ActivitiesManager activitiesManager;

    public ActivitiesManagerTest() {
        super(Activities.class);
    }

    @Autowired
    public void setActivitiesManager(ActivitiesManager activitiesManager) {
        this.activitiesManager = activitiesManager;
    }

    @Test
    public void testGetAll() {
        List<Activities> all = this.activitiesManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Activities> all={}", all); //$NON-NLS-1$
        }
    }
}
