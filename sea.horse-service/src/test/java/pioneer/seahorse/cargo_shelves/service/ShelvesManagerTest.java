package pioneer.seahorse.cargo_shelves.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;
import pioneer.seahorse.cargo_shelves.domain.Shelves;

import java.util.List;

public class ShelvesManagerTest extends GenericTreeManagerTestCase<Long, Shelves, ShelvesManager> {

    ShelvesManager shelvesManager;

    public ShelvesManagerTest() {
        super(Shelves.class);
    }

    @Autowired
    public void setShelvesManager(ShelvesManager shelvesManager) {
        this.shelvesManager = shelvesManager;
        this.manager = this.shelvesManager;
    }

    @Test
    public void testGetAll() {
        List<Shelves> all = this.shelvesManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Shelves> all={}", all); //$NON-NLS-1$
        }
    }

}
