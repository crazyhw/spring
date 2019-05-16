package s3;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class Usertest {
	
	
	@Transactional()
    @Test
    public void insert() {
    	
       /* Session session = rtn();
    	
        session.getTransaction().begin();*/
    	Configuration config=new Configuration().configure();     
    	
    	SessionFactory sessionFactory=config.buildSessionFactory();  //派生SessionFactor
    	Session session = sessionFactory.openSession();              //派生实例化对象session     
        User u=new User();
        u.setsame("王华");
        u.setAge(20);
        u.setAddress("北京");
        session.save(u);
        //session.getTransaction().commit();
        session.beginTransaction().commit(); 
    	// 提交事务
	
		// 回滚事务
		//session.getTransaction().rollback();
		if (session != null) {
			
		if (session.isOpen())
		{
				// 关闭session
		session.close();
		}
		}
		}
}
 