package pioneer.seahorse.orders.dao;

import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.orders.domain.Login_User;

@Repository("Login_userDao ")
public interface Login_userDao extends GenericDao<Login_User, Long> {


}
