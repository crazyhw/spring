package pioneer.seahorse.cargo.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.cargo.domain.Cargo;

import java.util.List;

public interface CargoManager extends GenericManager<Cargo, Long> {
    List<Cargo> getAll();

    Cargo findbyCargoId(Long id);

    Boolean deletebyCargoId(Long id);

    Cargo findbyCargoName(String name);

    Boolean AddCargo(Cargo cargo);

    Boolean UpdataCargo(Cargo cargo);

    Boolean DeleteCargo(Long id);

}