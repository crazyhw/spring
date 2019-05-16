package str;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;



public class Exe {
    static Configuration config = null;
    static SessionFactory sessionFactory = null;

    // ��ʼ��
    static {
        // ���غ��������ļ� Ĭ�ϼ�����·���µ�hibernate.cfg.xml
        config = new Configuration();
        config.configure();
        // ��������
        sessionFactory = config.buildSessionFactory();
    }

    // ����session
    public Session rtn() {
        return sessionFactory.openSession();
    }

    // �������
    @Test
    public void insert() {
        Session session = rtn();
        session.getTransaction().begin();
        User u = new User("laomu", "123", "����", new Date());
        session.save(u);
        session.getTransaction().commit();
    }

}