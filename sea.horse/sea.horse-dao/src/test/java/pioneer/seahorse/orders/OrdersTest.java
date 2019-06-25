package pioneer.seahorse.orders;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pioneer.seahorse.base.dao.GenericDaoTestCase;
import pioneer.seahorse.orders.dao.OrderDao;
import pioneer.seahorse.orders.domain.ordrs;

@ContextConfiguration(locations="classpath:/applicationContext-resources.xml")
public class OrdersTest extends GenericDaoTestCase<Long, ordrs, OrderDao>{

    @Autowired
    OrderDao op;

   @Transactional
    @Test
    public void TestOrderdao()

    {

        ordrs d1 = new ordrs();
        d1.setProductName("毛巾");
        d1.setOrderNo("d01");
        d1.setCurrentUnitPrice(11.23);
        d1.setQuantity(3);
        op.save(d1);
        op.flush();


        /*Configuration config=new Configuration().configure();
        SessionFactory sessionFactory=config.buildSessionFactory();
        Session session = sessionFactory.openSession();
         session.save(d1);
        //session.getTransaction().commit();
        session.beginTransaction().commit();
        // 提交事务

        // 回滚事务
        //session.getTransaction().rollback();
        if (session != null) {

            if (session.isOpen())
            {
                // 关闭session
                session.close();*/
            }
        }








/* extends BaseAbstractTestCase*/
