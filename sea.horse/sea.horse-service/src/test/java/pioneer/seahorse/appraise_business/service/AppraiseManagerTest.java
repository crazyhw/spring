package pioneer.seahorse.appraise_business.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.appraise_business.domain.Appraise;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import java.util.List;
/**
 *
 * @author 杨留阳
 * @Date  2019/5/10 20:25
 *
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