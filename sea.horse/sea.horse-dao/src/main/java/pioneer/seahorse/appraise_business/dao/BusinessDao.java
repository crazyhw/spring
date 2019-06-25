package pioneer.seahorse.appraise_business.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.base.dao.GenericTreeDao;
/**
 * BusinessDao
 * @author 杨留阳
 * @Date  2019/3/21 16:25
 */
@Repository("businessDao")
public interface BusinessDao extends GenericTreeDao<Business, Long> {

}
