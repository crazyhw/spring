package pioneer.seahorse.admin.domain;

import pioneer.seahorse.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * OneToMany
 * Group -- User
 */
@Entity
@Table(name = "SH_Group")
@NamedQueries({ @NamedQuery(name = "Group.getRoot", query = "select g from Group g where g.parent is null") })
public class Group extends BaseTreeEntity<Group> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8748825454057840907L;

	@Column(name = "NAME")
	String name;

	@OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Group{" +
				"name='" + name + '\'' +
				", users=" + users +
				'}';
	}
}
