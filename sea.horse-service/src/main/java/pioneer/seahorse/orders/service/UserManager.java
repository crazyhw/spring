package pioneer.seahorse.orders.service;

import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.order.damain.User;

import java.util.List;

public interface UserManager extends GenericTreeManager<User, Long> {

    List<User> getAll();

    User addUser( User shelves);

    User findbyUserId(Long id);

    Boolean deletebyUserId(Long id);

    User findbyUserName(String name);

    User UpdataUser(User user);

}
