package pioneer.seahorse.cargo_shelves.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.cargo_shelves.domain.Cargo;

import java.util.List;

public interface CargoManager extends GenericManager<Cargo, Long> {

    List<Cargo> getAll();

}
