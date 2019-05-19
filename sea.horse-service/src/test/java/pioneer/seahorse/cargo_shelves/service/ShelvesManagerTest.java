package pioneer.seahorse.cargo_shelves.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;
import pioneer.seahorse.cargo_shelves.domain.Shelves;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    public void testAddShelves() {
        for (int i = 0; i < 10; i++) {
            Shelves shelves = new Shelves();
            shelves.setName("shelves_" + i);
            shelves = this.shelvesManager.save(shelves);
            for (int j = 0; j < 10; j++) {
                Shelves subshelves = new Shelves();
                subshelves.setName("subshelves_" + i + "_" + j);
                subshelves.setParent(shelves);
                subshelves = this.shelvesManager.save(subshelves);
            }
        }

        List<Shelves> rootShelvesList = this.shelvesManager.getRoot();
        assertNotNull(rootShelvesList);
        assertEquals(10, rootShelvesList.size());


    }

}
