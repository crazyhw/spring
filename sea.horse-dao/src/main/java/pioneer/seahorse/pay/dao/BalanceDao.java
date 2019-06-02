package pioneer.seahorse.pay.dao;


import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.pay.domain.Balance;

@Repository("balanceDao")
public interface BalanceDao extends GenericDao<Balance, Long> {

}
