package pioneer.seahorse.distribution.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.distribution.domain.Deliveryclerk;
/**
 * DeliveryclerkDao
 * @author 郭万江
 * @Date  2019/4/1 14:12
 */
@Repository("deliveryclerkDao")
public interface DeliveryclerkDao extends GenericTreeDao<Deliveryclerk, Long> {

}
