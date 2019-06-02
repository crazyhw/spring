package pioneer.seahorse.distribution.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;
import pioneer.seahorse.distribution.domain.Deliveryclerk;

import java.util.List;

public class DeliveryclerkManagerTest extends GenericTreeManagerTestCase<Long, Deliveryclerk,DeliveryclerkManager> {

    DeliveryclerkManager deliveryclerkManager;

    public DeliveryclerkManagerTest() {
        super(Deliveryclerk.class);
    }

    @Autowired
    public void setDeliveryclerkManager(DeliveryclerkManager deliveryclerkManager) {
        this.deliveryclerkManager =deliveryclerkManager;
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
