package pioneer.seahorse.goods.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.goods.domain.Management;
/**
 * ManagementDao
 * @author 李培磊
 * @Date  2019/4/3 15:20
 */
@Repository("ManagementDao")
public interface ManagementDao extends GenericTreeDao<Management, Long> {

}
