package com.loquat.user.service;

import java.util.List;

import com.loquat.user.entity.Menu;

public interface MenuService extends IService<Menu>{
	
	List<Menu> getMenusByUserId(Long userId);
	
	List<Menu> menuTree();
	
	List<Long> getMenusByRoleId(Long roleId);
}
