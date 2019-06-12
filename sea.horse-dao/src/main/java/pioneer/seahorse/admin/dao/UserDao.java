package pioneer.seahorse.admin.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.admin.domain.User;
import pioneer.seahorse.base.dao.GenericDao;

@Repository("userDao")
public interface UserDao extends GenericDao<User, Long> {

}
