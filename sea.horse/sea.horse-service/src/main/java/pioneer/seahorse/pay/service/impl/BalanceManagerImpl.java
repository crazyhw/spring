package pioneer.seahorse.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.pay.dao.BalanceDao;
import pioneer.seahorse.pay.domain.Balance;
import pioneer.seahorse.pay.service.BalanceManager;

import java.util.List;
/**
 *
 * @author 吕庆宇
 * @Date  2019/5/8 17:32
 *
 */
@Service("balanceManager")
public class BalanceManagerImpl extends GenericManagerImpl<Balance, Long> implements BalanceManager {


    BalanceDao balanceDao;

    @Autowired
    public void setBalanceDao(BalanceDao balanceDao) {
        this.balanceDao = balanceDao;
        this.dao = this.balanceDao;
    }


    @Override
    public List<Balance> getAll() {
        List<Balance> all = this.balanceDao.findAll();
        return all;
    }

}
