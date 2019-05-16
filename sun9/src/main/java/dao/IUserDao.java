package dao;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("userDao")  
public interface IUserDao extends JpaRepository<User, Long>｛｝