package pioneer.seahorse.cargo_shelves.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.cargo_shelves.domain.Shelves;

@Repository("shelvesDao")
public interface ShelvesDao extends GenericTreeDao<Shelves, Long> {

}
