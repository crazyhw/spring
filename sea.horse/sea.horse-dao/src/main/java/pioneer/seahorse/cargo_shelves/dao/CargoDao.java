package pioneer.seahorse.cargo_shelves.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.cargo_shelves.domain.Cargo;

@Repository("cargoDao")
public interface CargoDao extends GenericDao<Cargo, Long> {

}
