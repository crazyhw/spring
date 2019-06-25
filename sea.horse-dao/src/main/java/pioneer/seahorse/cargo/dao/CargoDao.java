package pioneer.seahorse.cargo.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.cargo.domain.Cargo;

@Repository("cargoDao")
public interface CargoDao extends GenericDao<Cargo, Long> {
}
