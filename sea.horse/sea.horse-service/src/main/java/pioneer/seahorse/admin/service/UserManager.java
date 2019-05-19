package pioneer.seahorse.admin.service;

import pioneer.seahorse.admin.domain.User;
import pioneer.seahorse.base.service.GenericManager;

import java.util.List;

public interface UserManager extends GenericManager<User, Long> {

    String sayHello(String name);

    List<User> getAll();

}
