package pioneer.seahorse.cargo_shelves.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.cargo_shelves.domain.Shelves;

/**
 * ShelvesDao
 * @author 任鑫意
 * @Date  2019/3/21 16:18
 */
@Repository("shelvesDao")
public interface ShelvesDao extends GenericTreeDao<Shelves, Long> {

}
