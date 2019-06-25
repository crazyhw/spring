package pioneer.seahorse.order.service;

import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.orders.domain.Login_User;
import pioneer.seahorse.orders.domain.ordrs;

import java.math.BigDecimal;
import java.util.List;
@Service
public interface OrderManager extends GenericManager<ordrs, Long> {


    List<ordrs> getAll();

    public  void login1(Login_User t,String username , String passwd);
    public ordrs creteorder(ordrs t, String prname, int prono, BigDecimal price );




}
