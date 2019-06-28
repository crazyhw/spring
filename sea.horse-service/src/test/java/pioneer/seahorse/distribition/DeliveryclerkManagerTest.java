package pioneer.seahorse.distribition;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;
import pioneer.seahorse.distribition.domain.Deliveryclerk;
import pioneer.seahorse.distribition.service.DeliveryclerkManager;

import java.util.List;

/**
 * DeliveryclerkManagerTest 类
 *
 * @author 郭万江
 * @date 2019/6/27 15:14
 */
public class DeliveryclerkManagerTest extends GenericTreeManagerTestCase<Long, Deliveryclerk, DeliveryclerkManager> {
    DeliveryclerkManager deliveryclerkManager;

    public DeliveryclerkManagerTest() {
        super(Deliveryclerk.class);
    }

    @Autowired
    public void setDeliveryclerkManager(DeliveryclerkManager deliveryclerkManager) {
        this.deliveryclerkManager = deliveryclerkManager;
        this.manager = this.deliveryclerkManager;
    }

    @Test
    public void testGetAll() {
        List<Deliveryclerk> all = this.deliveryclerkManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Deliveryclerk> all={}", all); //$NON-NLS-1$
        }
    }
}
