package pioneer.seahorse.goods.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.goods.domain.Management;
/**
 * ManagementDao
 * @author lpl
 * @Date  2019/3/24 13:28
 */
@Repository("managementDao")
public interface ManagementDao extends GenericTreeDao<Management, Long>{
}
