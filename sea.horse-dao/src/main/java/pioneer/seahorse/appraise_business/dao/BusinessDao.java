package pioneer.seahorse.appraise_business.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.base.dao.GenericTreeDao;

@Repository("businessDao")
public interface BusinessDao extends GenericTreeDao<Business, Long> {

}
