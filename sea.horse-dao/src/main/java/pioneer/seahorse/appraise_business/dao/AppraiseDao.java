package pioneer.seahorse.appraise_business.dao;


import org.springframework.stereotype.Repository;
import pioneer.seahorse.appraise_business.domain.Appraise;
import pioneer.seahorse.base.dao.GenericDao;
/**
 * AppraiseDao
 * @author 杨留阳
 * @Date  2019/3/21 16:24
 */
@Repository("appraiseDao")
public interface AppraiseDao extends GenericDao<Appraise, Long> {

}