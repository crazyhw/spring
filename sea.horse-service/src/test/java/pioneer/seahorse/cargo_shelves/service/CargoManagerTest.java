package pioneer.seahorse.cargo_shelves.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.cargo_shelves.domain.Cargo;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CargoManagerTest extends GenericManagerTestCase<Long, Cargo, CargoManager> {

    private static final Logger logger = LogManager.getLogger(CargoManagerTest.class.getName());

    CargoManager userManager;

    public CargoManagerTest() {
        super(Cargo.class);
    }

    @Autowired
    public void setCargoManager(CargoManager userManager) {
        this.userManager = userManager;
    }

    @Test
    public void testGetAll() {
        List<Cargo> all = this.userManager.getAll();
        assertNotNull(all);
//		assertEquals(100, all.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Cargo> all={}", all); //$NON-NLS-1$
        }
    }

    @Test
    public void testSayHello() {
        String expected = "Hello, world!";
        String result = this.userManager.sayHello("world");
        if (logger.isInfoEnabled()) {
            logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
        }

        assertEquals(expected, result);
    }
}
