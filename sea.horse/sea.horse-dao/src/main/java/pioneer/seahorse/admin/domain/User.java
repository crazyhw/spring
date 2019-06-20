package pioneer.seahorse.admin.domain;


import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;

/**
 * ManyToOne
 * User -- Group
 */
@Entity
@Table(name = "SH_User")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2956980785739215106L;

	
	@Column(name = "EMAIL")
	String email;
	
	@ManyToOne
	@JoinColumn(name = "GROUP_ID")
	Group group;
	
	@Column(name = "PASSWORD")
	String password;
	@Column(name = "USERNAME")
	String username;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User{" +
				"email='" + email + '\'' +
				", group=" + group +
				", password='" + password + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}
