package pioneer.seahorse.pay.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.pay.domain.Balance;

import java.util.List;

public interface BalanceManager extends GenericManager<Balance, Long> {

    List<Balance> getAll();

}
