package pioneer.seahorse.goods.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.goods.domain.Management;

@Repository("ManagementDao")
public interface ManagementDao extends GenericTreeDao<Management, Long> {

}
