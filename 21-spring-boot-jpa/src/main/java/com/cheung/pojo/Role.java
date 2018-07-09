package com.cheung.pojo;

import javax.persistence.*;
import java.awt.print.Pageable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色 实体类
 *
 * @author Cheung
 */
@Entity
@Table(name = "jpa_role")
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
	 * @OneToMany 一对多，mappedBy="role"指定了由多方来维护关联关系，mappedBy的值是多方对一方的依赖的属性名，
	 * (注意：如果没有指定由谁来维护关联关系，则系统会给我们创建一张中间表)
	 */
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private Set<User> userSet = new HashSet<>();

	/**
	 * 角色:菜单   n:n
	 *
	 * @ManyToMany 多对多(cascade = CascadeType.PERSIST : 级联新增, fetch = FetchType.EAGER : 立即加载)
	 * @JoinTable 中间表(name : 表名, joinColumns : 当前表主键所关联的中间表的外键字段, inverseJoinColumns : 中间表另一侧的外键字段)
	 */
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "jpa_role_menu", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "menu_id"))
	private Set<Menu> menuSet = new HashSet<>();


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

	public Set<Menu> getMenuSet() {
		return menuSet;
	}

	public void setMenuSet(Set<Menu> menuSet) {
		this.menuSet = menuSet;
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
