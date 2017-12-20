package com.demo.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_menu database table.
 * 
 */
@Entity
@Table(name="role_menu")
@NamedQuery(name="RoleMenu.findAll", query="SELECT r FROM RoleMenu r")
public class RoleMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	private Menu menu;

	public RoleMenu() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}