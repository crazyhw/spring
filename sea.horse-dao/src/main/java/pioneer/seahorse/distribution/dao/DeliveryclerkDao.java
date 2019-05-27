package pioneer.seahorse.distribution.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.distribution.domain.Deliveryclerk;

@Repository("deliveryclerkDao")

public interface DeliveryclerkDao extends GenericTreeDao<Deliveryclerk,Long>{
}
