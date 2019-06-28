package pioneer.seahorse.order.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericTreeDao;
import pioneer.seahorse.order.damain.User;

@Repository("userDao")
public interface UserDao extends GenericTreeDao<User, Long> {

}
