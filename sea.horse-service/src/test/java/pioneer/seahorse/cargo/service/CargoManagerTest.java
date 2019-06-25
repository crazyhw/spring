package pioneer.seahorse.cargo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.cargo.domain.Cargo;

import java.util.List;

/**
 * CargoManagerTest 类
 *
 * @author 任鑫意
 * @date 2019/6/20 17:27
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
