package str;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;



public class Exe {
    static Configuration config = null;
    static SessionFactory sessionFactory = null;

    // 初始化
    static {
        // 加载核心配置文件 默认加载类路径下的hibernate.cfg.xml
        config = new Configuration();
        config.configure();
        // 创建工厂
        sessionFactory = config.buildSessionFactory();
    }

    // 返回session
    public Session rtn() {
        return sessionFactory.openSession();
    }

    // 保存测试
    @Test
    public void insert() {
        Session session = rtn();
        session.getTransaction().begin();
        User u = new User("laomu", "123", "老孙", new Date());
        session.save(u);
        session.getTransaction().commit();
    }

}