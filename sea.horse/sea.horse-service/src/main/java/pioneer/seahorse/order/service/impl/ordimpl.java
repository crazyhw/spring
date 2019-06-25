package pioneer.seahorse.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.admin.dao.UserDao;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.goods.domain.Goods;
import pioneer.seahorse.goods.service.GoodsManager;
import pioneer.seahorse.order.service.OrderManager;
import pioneer.seahorse.orders.dao.OrderDao;
import pioneer.seahorse.orders.domain.Login_User;
import pioneer.seahorse.orders.domain.ordrs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;
@Service
public class  ordimpl extends GenericManagerImpl<ordrs, Long> implements OrderManager

{
    @Autowired
    OrderDao op;
    @Autowired
    UserDao userop;
    @Override
    public List<ordrs> getAll() {
        return null;
    }

    @Override
    public void login1(Login_User user,String username , String passwd)
    {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "ApplicationEntityManager");
        EntityManager entitymanager = emfactory.createEntityManager();
        Query query = entitymanager.createQuery("select t.username,t.password from  Login_User t where t.username= ?1 and t.password = ?2");
        /*query.setParameter(1, name);
        query.setParameter(2, password);
        Query query = entitymanager.createQuery("Select e.username from Login_User e");
        List<String> list=query.getResultList();*/



    }
    public Login_User login(Login_User user,String username ,String passwd)
    {

        //return  userop.findByNameAndPassword(user.getUsername(),user.getPassword());
        return null;

    }


    @Override
    public ordrs creteorder(ordrs t, String prname, int prono, BigDecimal price) {
        t.setProductName("prname");
        t.setProductId(prono);
        t.setTotalPrice(price);
        return op.save(t);


    }




}
