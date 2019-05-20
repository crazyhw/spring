package pioneer.seahorse.cargo_shelves.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.cargo_shelves.domain.Shelves;

public class ShelvesGenerator extends GenericGenerator {

    ShelvesManager shelvesManager;

    @Autowired
    public void setShelvesManager(ShelvesManager shelvesManager) {
        this.shelvesManager = shelvesManager;
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
                this.shelvesManager.save(subshelves);
            }

        }

    }

}
