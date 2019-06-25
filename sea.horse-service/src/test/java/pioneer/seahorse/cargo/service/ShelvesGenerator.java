package pioneer.seahorse.cargo.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.cargo.domain.Cargo;
import pioneer.seahorse.cargo.domain.Shelves;

/**
 * ShelvesGenerator 类
 *
 * @author 任鑫意
 * @date 2019/6/20 17:30
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

    /*@Test
    public void AddShelves() {
        for (int i = 0; i < 1; i++) {
            Shelves shelves = new Shelves();
            shelves.setName("shelves_" + i);
            this.shelvesManager.save(shelves);
            for (int j = 0; j < 1; j++) {
                Shelves subshelves = new Shelves();
                subshelves.setName("subshelves_" + i + "_" + j);
                subshelves.setParent(shelves);
                this.shelvesManager.save(subshelves);
                this.AddCargo(shelves);
            }
        }
    }

    public void AddCargo(Shelves shelves) {
        for (int i = 0; i < 1; i++) {
            Cargo cargo = new Cargo();
            cargo.setName("cargo_" + i);
            cargo.setAddress("中原工学院");
            cargo.setContact(i+123456);
            cargo.setShelves(shelves);
            this.cargoManager.save(cargo);
        }
    }*/

    @Test
    public void AddShelves() {
            Shelves shelves = new Shelves();
            shelves.setName("第一货架");
            this.shelvesManager.save(shelves);
                this.AddCargo(shelves);
    }

    public void AddCargo(Shelves shelves) {
            Cargo cargo = new Cargo();
            cargo.setName("货物");
            cargo.setNum("1");
            cargo.setPrice(123);
            cargo.setNumber(100);
            cargo.setShelves(shelves);
            this.cargoManager.save(cargo);
    }

}
