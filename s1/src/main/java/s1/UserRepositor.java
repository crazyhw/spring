package s1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//public interface UserRepository extends  CrudRepository<User,Integer>{}
//@Repository("userDao")

public interface UserRepositor extends JpaRepository<User,Integer>{ public User findByName(String name);};

	

