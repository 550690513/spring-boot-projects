package com.cheung.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色实体类
 *
 * @author Cheung
 */
@Entity
@Table(name = "role_jpa")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;

	@Column(name = "role_name")
	private String roleName;

	/**
	 * 角色:用户   1:n
	 *
	 * @OneToMany 指定了一对多的关系，mappedBy="role"指定了由多的那一方来维护关联关系，mappedBy指的是多的一方对一的这一方的依赖的属性，
	 * (注意：如果没有指定由谁来维护关联关系，则系统会给我们创建一张中间表)
	 */
	@OneToMany(mappedBy = "role")
	private Set<User> userSet = new HashSet<>();


	public Role() {
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

	@Override
	public String toString() {
		return "Role{" +
				"roleId=" + roleId +
				", roleName='" + roleName + '\'' +
				", userSet=" + userSet +
				'}';
	}
}
