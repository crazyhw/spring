package pioneer.seahorse.appraise_business.dao;


import org.springframework.stereotype.Repository;
import pioneer.seahorse.appraise_business.domain.Appraise;
import pioneer.seahorse.base.dao.GenericDao;

@Repository("appraiseDao")
public interface AppraiseDao extends GenericDao<Appraise, Long> {

}