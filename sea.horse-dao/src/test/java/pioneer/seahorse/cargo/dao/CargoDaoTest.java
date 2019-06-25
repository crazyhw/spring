package pioneer.seahorse.cargo.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.cargo.domain.Cargo;

import java.util.List;

/**
 * CargoDaoTest 类
 *
 * @author 任鑫意
 * @date 2019/6/20 17:16
 */
public class CargoDaoTest extends GenericDaoTestCase<Long, Cargo, CargoDao> {
    private static final Logger logger = LogManager.getLogger(CargoDaoTest.class.getName());
    @Autowired
    CargoDao cargoDao;

    @Test
    public void testFindAll() {

        List<Cargo> all = this.cargoDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Cargo> all={}", all); //$NON-NLS-1$
        }
    }
}
