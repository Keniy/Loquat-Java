package com.loquat.user.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Menu {
	
	private Long id;
	private String url;
	private String path;
	private Object component;
	private String name;
	private String iconCls;
	private Long parentId;
	private List<Role> roles;
	private List<Menu> children;
	private MenuMeta meta;
}
