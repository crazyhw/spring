package pioneer.seahorse.cargo.service;

import org.springframework.web.bind.annotation.RequestBody;
import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.cargo.domain.Shelves;

import java.util.List;

public interface ShelvesManager extends GenericTreeManager<Shelves, Long> {

    List<Shelves> getAll();

    Shelves addShelves( Shelves shelves);

    Shelves findbyShelvesId(Long id);

    Boolean deletebyShelvesId(Long id);

    Shelves findbyShelvesName(String name);

    Shelves UpdataShelves(Shelves shelves);

    void reduce(Shelves shelves);

    void updata();
}
