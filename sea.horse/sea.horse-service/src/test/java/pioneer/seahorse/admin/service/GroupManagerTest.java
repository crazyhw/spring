package pioneer.seahorse.admin.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.admin.domain.Group;
import pioneer.seahorse.base.service.GenericTreeManagerTestCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;

public class GroupManagerTest extends GenericTreeManagerTestCase<Long, Group, GroupManager> {

    GroupManager groupManager;

    public GroupManagerTest() {
        super(Group.class);
    }

    @Autowired
    public void setGroupManager(GroupManager groupManager) {
        this.groupManager = groupManager;
        this.manager = this.groupManager;
    }

    @Test
    public void testAddGroup() {
        for (int i = 0; i < 10; i++) {
            Group group = new Group();
            group.setName("group_" + i);
            group = this.groupManager.save(group);
            for (int j = 0; j < 10; j++) {
                Group subgroup = new Group();
                subgroup.setName("subgroup_" + i + "_" + j);
                subgroup.setParent(group);
                subgroup = this.groupManager.save(subgroup);
            }
        }

        List<Group> rootGroupList = this.groupManager.getRoot();
        assertNotNull(rootGroupList);
        assertEquals(10, rootGroupList.size());


    }

}
