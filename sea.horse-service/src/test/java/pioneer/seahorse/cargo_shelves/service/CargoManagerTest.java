package pioneer.seahorse.cargo_shelves.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.cargo_shelves.domain.Cargo;
import java.util.List;
/**
 *
 * @author 任鑫意
 * @Date  2019/5/11 17:11
 *
 */
public class CargoManagerTest extends GenericManagerTestCase<Long, Cargo, CargoManager> {

    private static final Logger logger = LogManager.getLogger(CargoManagerTest.class.getName());

    CargoManager cargoManager;

    public CargoManagerTest() {
        super(Cargo.class);
    }

    @Autowired
    public void setCargoManager(CargoManager cargoManager) {
        this.cargoManager = cargoManager;
    }

    @Test
    public void testGetAll() {
        List<Cargo> all = this.cargoManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Cargo> all={}", all); //$NON-NLS-1$
        }
    }

}
