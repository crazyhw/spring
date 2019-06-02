
package pioneer.seahorse.pay.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericManagerTestCase;
import pioneer.seahorse.pay.domain.Balance;
import java.util.List;

public class BalanceManagerTest extends GenericManagerTestCase<Long, Balance, BalanceManager> {

    private static final Logger logger = LogManager.getLogger(BalanceManagerTest.class.getName());

    BalanceManager balanceManager;

    public BalanceManagerTest() {
        super(Balance.class);
    }

    @Autowired
    public void setBalanceManager(BalanceManager balanceManager) {
        this.balanceManager = balanceManager;
    }

    @Test
    public void testGetAll() {
        List<Balance> all = this.balanceManager.getAll();
        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Balance> all={}", all); //$NON-NLS-1$
        }
    }

}
