package pioneer.seahorse.pay.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.pay.domain.Balance;

import java.util.List;
/**
 *
 * @author 吕庆宇
 * @Date  2019/5/8 17:32
 *
 */
public interface BalanceManager extends GenericManager<Balance, Long> {

    List<Balance> getAll();

}
