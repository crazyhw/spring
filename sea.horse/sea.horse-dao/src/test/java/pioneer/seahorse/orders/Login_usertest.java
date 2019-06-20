package pioneer.seahorse.orders;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.orders.domain.Login_User;
import pioneer.seahorse.orders.dao.Login_userDao;

@ContextConfiguration(locations="classpath:/applicationContext-resources.xml")

public class Login_usertest extends GenericDaoTestCase<Long, Login_User, Login_userDao> {

    @Autowired
    Login_userDao op;

    @Transactional
    @Test
    public void TestLogin_userdao()
    {

        Login_User admin=new Login_User();
        admin.setUsername("李磊");
        admin.setPassword("123456");
        admin.setEmail("qx@sina.cn");
        op.save(admin);
        op.flush();
    }

}

