package pioneer.seahorse.shop_activities.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.shop_activities.domain.Activities;

/**
 * @author lvqingyv
 * @date 2019/6/21 19:23
 */
@Repository("activitiesDao")
public interface ActivitiesDao  extends GenericDao<Activities, Long> {

}

