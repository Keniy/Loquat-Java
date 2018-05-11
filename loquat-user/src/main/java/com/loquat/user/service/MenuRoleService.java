package com.loquat.user.service;

public interface MenuRoleService {
	
	int deleteMenuByRoleId(Long roleId);
	
	int addMenu(Long roleId, Long[] mids);
}
