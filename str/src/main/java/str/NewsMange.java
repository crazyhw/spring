/*package str;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class NewsMange {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
                .build();

        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        News news = new News();
        news.setName("sdongwan_content");
        news.setId(232);
       
        session.save(news);
        transaction.commit();

        sessionFactory.close();

    }
}*/
