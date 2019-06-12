package pioneer.seahorse.admin.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.admin.domain.Role;
import pioneer.seahorse.base.dao.GenericDao;

@Repository("roleDao")
public interface RoleDao extends GenericDao<Role, Long> {

}
