package com.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int active;

	@Temporal(TemporalType.DATE)
	@Column(name="create_time")
	private Date createTime;

	private String creator;

	@Column(name="menu_desc")
	private String menuDesc;

	@Column(name="menu_name")
	private String menuName;

	private String menu_URL;

	@Temporal(TemporalType.DATE)
	@Column(name="update_time")
	private Date updateTime;

	private String updator;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Menu menu1;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="menu1")
	private List<Menu> menus1;


	public Menu() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getMenuDesc() {
		return this.menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenu_URL() {
		return this.menu_URL;
	}

	public void setMenu_URL(String menu_URL) {
		this.menu_URL = menu_URL;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdator() {
		return this.updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public Menu getMenu1() {
		return this.menu1;
	}

	public void setMenu1(Menu menu1) {
		this.menu1 = menu1;
	}

	public List<Menu> getMenus1() {
		return this.menus1;
	}

	public void setMenus1(List<Menu> menus1) {
		this.menus1 = menus1;
	}

	public Menu addMenus1(Menu menus1) {
		getMenus1().add(menus1);
		menus1.setMenu1(this);

		return menus1;
	}

	public Menu removeMenus1(Menu menus1) {
		getMenus1().remove(menus1);
		menus1.setMenu1(null);

		return menus1;
	}
}