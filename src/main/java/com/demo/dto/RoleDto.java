package com.demo.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.demo.domain.RoleMenu;
import com.demo.domain.UserRole;

import lombok.Data;


/**
 * The persistent class for the role database table.
 * 
 */
@Data
public class RoleDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String roleDesc;

	private String roleName;

	private List<RoleMenu> roleMenus;

	private List<UserRole> userRoles;

	public RoleDto() {
		// TODO Auto-generated constructor stub
	}

}