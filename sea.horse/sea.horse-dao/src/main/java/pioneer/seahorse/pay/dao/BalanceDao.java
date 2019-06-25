package pioneer.seahorse.pay.dao;


import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.pay.domain.Balance;
/**
 * BalanceDao
 * @author 吕庆宇
 * @Date  2019/4/5 16:32
 */
@Repository("balanceDao")
public interface BalanceDao extends GenericDao<Balance, Long> {

}
