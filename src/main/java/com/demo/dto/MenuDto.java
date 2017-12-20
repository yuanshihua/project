package com.demo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.demo.domain.Menu;

import lombok.Data;


/**
 * The persistent class for the menu database table.
 * 
 */
@Data
public class MenuDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private int active;

	private Date createTime;

	private String creator;

	private String menuDesc;

	private String menuName;

	private String menu_URL;

	private Date updateTime;

	private String updator;

	private Menu menu1;

	private List<Menu> menus1;

	private Menu menu2;

	private List<Menu> menus2;

	public MenuDto() {
	}
}