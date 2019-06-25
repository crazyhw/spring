package pioneer.seahorse.cargo.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.cargo.domain.Shelves;


@Repository("shelvesDao")
public interface ShelvesDao extends GenericTreeDao<Shelves, Long> {

}
