package pioneer.seahorse.admin.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.admin.domain.Group;
import pioneer.seahorse.base.service.GenericGenerator;

public class GroupGenerator extends GenericGenerator {

    GroupManager groupManager;

    @Autowired
    public void setGroupManager(GroupManager groupManager) {
        this.groupManager = groupManager;
    }

    @Test
    public void testAddGroup() {
        for (int i = 0; i < 3; i++) {
            Group group = new Group();
            group.setName("group_" + i);
            group = this.groupManager.save(group);
            for (int j = 0; j < 3; j++) {
                Group subgroup = new Group();
                subgroup.setName("subgroup_" + i + "_" + j);
                subgroup.setParent(group);
                this.groupManager.save(subgroup);
            }

        }

    }

}
