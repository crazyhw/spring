package edu.zut.cs.software.sun.admin.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.sun.admin.domain.Group;

public class GroupGenerator extends GenericGenerator {

	GroupManager groupManager;

	@Autowired
	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
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
				this.groupManager.save(subgroup);
			}
			
		}

	}

}
