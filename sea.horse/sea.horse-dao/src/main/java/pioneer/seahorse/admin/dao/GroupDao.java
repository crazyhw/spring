package pioneer.seahorse.admin.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.admin.domain.Group;
import pioneer.seahorse.base.dao.GenericTreeDao;

@Repository("groupDao")
public interface GroupDao extends GenericTreeDao<Group, Long> {

}
