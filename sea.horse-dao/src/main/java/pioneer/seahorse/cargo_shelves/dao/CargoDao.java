package pioneer.seahorse.cargo_shelves.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.cargo_shelves.domain.Cargo;

/**
 * CargoDao
 * @author 任鑫意
 * @Date  2019/3/20 16:17
 */
@Repository("cargoDao")
public interface CargoDao extends GenericDao<Cargo, Long> {

}
