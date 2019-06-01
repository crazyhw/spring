package pioneer.seahorse.cargo_shelves.service;

import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.cargo_shelves.domain.Shelves;
import java.util.List;

public interface ShelvesManager extends GenericTreeManager<Shelves, Long> {
    List<Shelves> getAll();
}
