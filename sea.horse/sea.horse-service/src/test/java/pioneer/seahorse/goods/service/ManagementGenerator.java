package pioneer.seahorse.goods.service;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.goods.domain.Management;
/**
 *
 * @author 李培磊
 * @Date  2019/5/20 21:58
 *
 */
public class ManagementGenerator extends GenericGenerator {

    ManagementManager managementManager;
    @Autowired
    public void setManagementManager(ManagementManager managementManager) {
        this.managementManager = managementManager;
    }
    @Test
    public void testAddManagement() {
        for (int i = 0; i < 3; i++) {
            Management management = new Management();
            management.setName("management_" + i);
            management = this.managementManager.save(management);
            for (int j = 0; j < 3; j++) {
                Management submanagement = new Management();
                submanagement.setName("submanagement_" + i + "_" + j);
                submanagement.setParent(management);
                this.managementManager.save(submanagement);
            }

        }

    }
}
