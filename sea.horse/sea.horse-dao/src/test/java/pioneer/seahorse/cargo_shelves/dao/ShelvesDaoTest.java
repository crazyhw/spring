package pioneer.seahorse.cargo_shelves.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.dao.GenericTreeDaoTestCase;
import pioneer.seahorse.cargo_shelves.domain.Shelves;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShelvesDaoTest extends GenericTreeDaoTestCase<Long, Shelves, ShelvesDao> {

    private static final Logger logger = LogManager.getLogger(ShelvesDaoTest.class.getName());

    ShelvesDao shelvesDao;

    @Autowired
    public void setShelvesDao(ShelvesDao shelvesDao) {
        this.shelvesDao = shelvesDao;
        this.dao = this.shelvesDao;
    }

    @Test
    public void testGetRoot() {
        int root_size = 10;
        for(int i = 0; i < root_size; i++) {
            Shelves shelves = new Shelves();
            shelves.setName("shelves_" + i);
            for(int j = 0; j < 10; j++) {
                Shelves s = new Shelves();
                s.setName("shelves_" + i + "_" + j);
                s.setParent(shelves);
            }
            this.shelvesDao.save(shelves);
        }

        List<Shelves> roots = this.shelvesDao.getRoot();
        assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Shelves> roots={}", roots); //$NON-NLS-1$
        }


    }

}

