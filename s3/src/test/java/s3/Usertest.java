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
    	
    	SessionFactory sessionFactory=config.buildSessionFactory();  //����SessionFactor
    	Session session = sessionFactory.openSession();              //����ʵ��������session     
        User u=new User();
        u.setsame("����");
        u.setAge(20);
        u.setAddress("����");
        session.save(u);
        //session.getTransaction().commit();
        session.beginTransaction().commit(); 
    	// �ύ����
	
		// �ع�����
		//session.getTransaction().rollback();
		if (session != null) {
			
		if (session.isOpen())
		{
				// �ر�session
		session.close();
		}
		}
		}
}
 