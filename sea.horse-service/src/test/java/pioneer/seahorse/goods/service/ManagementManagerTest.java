package pioneer.seahorse.goods.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;
import pioneer.seahorse.goods.domain.Management;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ManagementManagerTest extends GenericTreeManagerTestCase<Long, Management, ManagementManager> {
    ManagementManager managementManager;

    public ManagementManagerTest() {
        super(Management.class);
    }

    @Autowired
    public void setManagementManager(ManagementManager managementManager) {
        this.managementManager = managementManager;
        this.manager = this.managementManager;
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
                submanagement = this.managementManager.save(submanagement);
            }
        }
    }
}
