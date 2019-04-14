package sun8;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class App {
    /*static Configuration config = null;
    static SessionFactory sessionFactory = null;
	private User u;

  
    static {
       
        config = new Configuration();
        config.configure();
    

    sessionFactory = config.buildSessionFactory();
    }

    // 返回session
    public Session rtn() {
        return sessionFactory.openSession();
    }

    // 保存测试*/
    @Test
    public void insert() {
    	
       /* Session session = rtn();
    	
        session.getTransaction().begin();*/
    	Configuration config=new Configuration().configure(); SessionFactory 
    	sessionFactory=config.buildSessionFactory();
    	Session session = sessionFactory.openSession();
        User u=new User();
         u.setId(1235);
        u.setName("李华");
        u.setAge(20);
        session.save(u);
        session.getTransaction().commit();
    }

}