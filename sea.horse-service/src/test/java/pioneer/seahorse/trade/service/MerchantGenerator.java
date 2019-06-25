package pioneer.seahorse.trade.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.trade.dao.MerchantDao;

/**
 * MerchantGeneric 类
 *
 * @author 于靖鑫
 * @date 2019/6/3 17:43
 */
public class MerchantGenerator extends GenericGenerator {

    private static final Logger logger = LogManager.getLogger(pioneer.seahorse.trade.service.MerchantGenerator.class.getName());

    @Autowired
    MerchantDao merchantDao;

    @Test
    public void AddMerchant()
    {
    }
}
