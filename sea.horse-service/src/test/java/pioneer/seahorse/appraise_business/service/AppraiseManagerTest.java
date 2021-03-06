package pioneer.seahorse.appraise_business.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.appraise_business.domain.Appraise;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.cargo.domain.Cargo;
import pioneer.seahorse.cargo.service.CargoManager;

import java.util.List;

/**
 * AppraiseManagerTest 类
 *
 * @author 杨留阳
 * @date 2019/6/27 16:24
 */
public class AppraiseManagerTest extends GenericManagerTestCase<Long, Appraise, AppraiseManager> {
    private static final Logger logger = LogManager.getLogger(AppraiseManagerTest.class.getName());

    AppraiseManager appraiseManager;

    public AppraiseManagerTest() {
        super(Appraise.class);
    }

    @Autowired
    public void setAppraiseManager(AppraiseManager appraiseManager) {
        this.appraiseManager = appraiseManager;
    }

    @Test
    public void testGetAll() {
        List<Appraise> all = this.appraiseManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Appraise> all={}", all); //$NON-NLS-1$
        }
    }
}
