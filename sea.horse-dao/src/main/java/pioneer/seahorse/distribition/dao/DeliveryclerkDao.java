package pioneer.seahorse.distribition.dao;

import org.springframework.stereotype.Repository;


import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.distribition.domain.Deliveryclerk;

@Repository("deliveryclerkDao")
public interface DeliveryclerkDao extends GenericTreeDao<Deliveryclerk, Long> {

}

