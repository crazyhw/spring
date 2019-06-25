package pioneer.seahorse.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;
import pioneer.seahorse.goods.dao.ManagementDao;
import pioneer.seahorse.goods.domain.Management;
import pioneer.seahorse.goods.service.ManagementManager;
/**
 *
 * @author 李培磊
 * @Date  2019/5/7 18:36
 *
 */
@Service(value = "managementManager")
public class ManagementManagerImpl extends GenericTreeManagerImpl<Management, Long> implements ManagementManager {

    ManagementDao managementDao;

    @Autowired
    public void setManagementDao(ManagementDao managementDao) {
        this.managementDao = managementDao;
        this.treeDao = this.managementDao;
        this.dao = this.treeDao;
    }

}
