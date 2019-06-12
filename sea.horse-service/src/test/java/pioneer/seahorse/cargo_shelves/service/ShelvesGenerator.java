package pioneer.seahorse.cargo_shelves.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.cargo_shelves.domain.Cargo;
import pioneer.seahorse.cargo_shelves.domain.Shelves;

/**
 * Add测试
 * @author 任鑫意
 * @Date  2019/5/11 17:11
 *
 */
public class ShelvesGenerator extends GenericGenerator {

    CargoManager cargoManager;
    ShelvesManager shelvesManager;

    @Autowired
    public void setShelvesManager(ShelvesManager shelvesManager) {
        this.shelvesManager = shelvesManager;
    }

    @Autowired
    public void setCargoManager(CargoManager cargoManager) {
        this.cargoManager = cargoManager;
    }

    @Test
    public void AddShelves() {
        for (int i = 0; i < 3; i++) {
            Shelves shelves = new Shelves();
            shelves.setName("shelves_" + i);
            this.shelvesManager.save(shelves);
            for (int j = 0; j < 3; j++) {
                Shelves subshelves = new Shelves();
                subshelves.setName("subshelves_" + i + "_" + j);
                subshelves.setParent(shelves);
                this.shelvesManager.save(subshelves);
                this.AddCargo(shelves);
            }
        }
    }

    public void AddCargo(Shelves shelves) {
        for (int i = 0; i < 3; i++) {
            Cargo cargo = new Cargo();
            cargo.setName("cargo_" + i);
            cargo.setCount(i+10);
            cargo.setPrice(100);
            cargo.setShelves(shelves);
            this.cargoManager.save(cargo);
        }
    }
}
