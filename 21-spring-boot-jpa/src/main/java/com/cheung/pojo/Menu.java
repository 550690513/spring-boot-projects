package com.cheung.pojo;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

/**
 * 菜单 实体类
 *
 * @author Cheung
 */
@Entity
@Table(name = "jpa_menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Integer menuId;

	@Column(name = "menu_name")
	private String menuName;

	@Column(name = "menu_url")
	private String menuUrl;

	@Column(name = "father_id")
	private Integer fatherId;

	/**
	 * 菜单:角色   n:n
	 *
	 * @ManyToMany 多对多，mappedBy="menuSet"指定了由另一侧来维护关联关系，mappedBy的值为另一侧对自身的依赖的属性名
	 */
	@ManyToMany(mappedBy = "menuSet")
	private Set<Role> roleSet = new HashSet<>();

	public Menu() {
	}

	public Menu(String menuName, String menuUrl, Integer fatherId) {
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.fatherId = fatherId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getFatherId() {
		return fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	@Override
	public String toString() {
		return "Menu{" +
				"menuId=" + menuId +
				", menuName='" + menuName + '\'' +
				", menuUrl='" + menuUrl + '\'' +
				", fatherId='" + fatherId + '\'' +
				'}';
	}
}
